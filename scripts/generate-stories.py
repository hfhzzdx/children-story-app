#!/usr/bin/env python3
"""
小墩子故事屋 - AI故事生成脚本

这个脚本使用AI生成儿童故事，支持批量生成和内容去重。
"""

import json
import os
import hashlib
import sqlite3
from datetime import datetime
from typing import List, Dict, Optional
import random

# 配置
CONFIG = {
    "database_path": "stories.db",
    "output_dir": "generated_stories",
    "categories": [
        "通话故事", "绘本故事", "睡前故事", 
        "成语故事", "寓言故事", "科普故事"
    ],
    "age_ranges": ["3-4", "4-5", "5-6"],
    "themes": {
        "通话故事": ["友谊", "家庭", "分享", "礼貌", "勇敢"],
        "绘本故事": ["动物", "自然", "颜色", "形状", "数字"],
        "睡前故事": ["梦境", "星星", "月亮", "晚安", "平静"],
        "成语故事": ["智慧", "勤奋", "诚实", "谦虚", "坚持"],
        "寓言故事": ["道德", "教训", "选择", "后果", "价值"],
        "科普故事": ["自然", "科学", "探索", "发现", "学习"]
    },
    "story_lengths": {
        "3-4": "300-500字",
        "4-5": "400-600字", 
        "5-6": "500-800字"
    }
}

class StoryGenerator:
    """故事生成器基类"""
    
    def __init__(self, config: Dict):
        self.config = config
        self.setup_database()
        self.setup_output_dir()
        
    def setup_database(self):
        """设置数据库"""
        os.makedirs(os.path.dirname(self.config["database_path"]), exist_ok=True)
        self.conn = sqlite3.connect(self.config["database_path"])
        self.create_tables()
        
    def create_tables(self):
        """创建数据库表"""
        cursor = self.conn.cursor()
        
        # 故事表
        cursor.execute('''
        CREATE TABLE IF NOT EXISTS stories (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            title TEXT NOT NULL,
            content TEXT NOT NULL,
            category TEXT NOT NULL,
            age_range TEXT NOT NULL,
            theme TEXT NOT NULL,
            length TEXT,
            hash TEXT UNIQUE NOT NULL,
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            word_count INTEGER,
            tags TEXT,
            source TEXT DEFAULT 'ai'
        )
        ''')
        
        # 故事相似度表（用于去重）
        cursor.execute('''
        CREATE TABLE IF NOT EXISTS story_similarity (
            story_id1 INTEGER,
            story_id2 INTEGER,
            similarity REAL,
            PRIMARY KEY (story_id1, story_id2),
            FOREIGN KEY (story_id1) REFERENCES stories (id),
            FOREIGN KEY (story_id2) REFERENCES stories (id)
        )
        ''')
        
        # 生成任务表
        cursor.execute('''
        CREATE TABLE IF NOT EXISTS generation_tasks (
            id INTEGER PRIMARY KEY AUTOINCREMENT,
            category TEXT NOT NULL,
            age_range TEXT NOT NULL,
            theme TEXT NOT NULL,
            count INTEGER NOT NULL,
            status TEXT DEFAULT 'pending',
            created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
            completed_at TIMESTAMP,
            success_count INTEGER DEFAULT 0,
            fail_count INTEGER DEFAULT 0
        )
        ''')
        
        self.conn.commit()
        
    def setup_output_dir(self):
        """设置输出目录"""
        os.makedirs(self.config["output_dir"], exist_ok=True)
        
    def calculate_content_hash(self, content: str) -> str:
        """计算内容哈希值（用于去重）"""
        # 简单处理：移除空格和标点，转换为小写
        cleaned = ''.join(c.lower() for c in content if c.isalnum() or c.isspace())
        return hashlib.md5(cleaned.encode()).hexdigest()
    
    def calculate_similarity(self, text1: str, text2: str) -> float:
        """计算文本相似度（简单实现）"""
        # 将文本转换为词集合
        words1 = set(text1.lower().split())
        words2 = set(text2.lower().split())
        
        if not words1 or not words2:
            return 0.0
            
        # 计算Jaccard相似度
        intersection = len(words1.intersection(words2))
        union = len(words1.union(words2))
        
        return intersection / union if union > 0 else 0.0
    
    def check_duplicate(self, content: str, threshold: float = 0.8) -> bool:
        """检查是否与已有故事重复"""
        content_hash = self.calculate_content_hash(content)
        
        cursor = self.conn.cursor()
        
        # 首先检查完全相同的哈希
        cursor.execute('SELECT id, content FROM stories WHERE hash = ?', (content_hash,))
        existing = cursor.fetchone()
        
        if existing:
            return True
            
        # 检查相似内容
        cursor.execute('SELECT id, content FROM stories')
        all_stories = cursor.fetchall()
        
        for story_id, existing_content in all_stories:
            similarity = self.calculate_similarity(content, existing_content)
            if similarity > threshold:
                # 记录相似度
                cursor.execute('''
                INSERT OR IGNORE INTO story_similarity (story_id1, story_id2, similarity)
                VALUES (?, ?, ?)
                ''', (story_id, story_id, similarity))
                return True
                
        return False
    
    def generate_story(self, category: str, age_range: str, theme: str) -> Optional[Dict]:
        """生成单个故事（需要子类实现）"""
        raise NotImplementedError("子类必须实现此方法")
    
    def save_story(self, story: Dict) -> bool:
        """保存故事到数据库"""
        try:
            cursor = self.conn.cursor()
            
            # 检查是否重复
            if self.check_duplicate(story["content"]):
                print(f"故事重复，跳过保存: {story['title']}")
                return False
                
            # 计算词数
            word_count = len(story["content"].split())
            
            # 计算哈希
            content_hash = self.calculate_content_hash(story["content"])
            
            # 插入数据库
            cursor.execute('''
            INSERT INTO stories (title, content, category, age_range, theme, length, hash, word_count, tags)
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
            ''', (
                story["title"],
                story["content"],
                story["category"],
                story["age_range"],
                story["theme"],
                story.get("length", ""),
                content_hash,
                word_count,
                json.dumps(story.get("tags", []), ensure_ascii=False)
            ))
            
            story_id = cursor.lastrowid
            
            # 保存到文件
            self.save_to_file(story, story_id)
            
            self.conn.commit()
            print(f"故事保存成功: {story['title']} (ID: {story_id})")
            return True
            
        except Exception as e:
            print(f"保存故事失败: {e}")
            self.conn.rollback()
            return False
    
    def save_to_file(self, story: Dict, story_id: int):
        """保存故事到文件"""
        filename = f"story_{story_id:06d}_{story['category']}_{story['age_range']}.json"
        filepath = os.path.join(self.config["output_dir"], filename)
        
        # 添加元数据
        story_with_meta = {
            "id": story_id,
            "metadata": {
                "generated_at": datetime.now().isoformat(),
                "version": "1.0",
                "generator": self.__class__.__name__
            },
            **story
        }
        
        with open(filepath, 'w', encoding='utf-8') as f:
            json.dump(story_with_meta, f, ensure_ascii=False, indent=2)
    
    def batch_generate(self, category: str, age_range: str, theme: str, count: int) -> Dict:
        """批量生成故事"""
        print(f"开始批量生成: {category} - {age_range}岁 - {theme}主题 - {count}个")
        
        cursor = self.conn.cursor()
        
        # 创建生成任务
        cursor.execute('''
        INSERT INTO generation_tasks (category, age_range, theme, count)
        VALUES (?, ?, ?, ?)
        ''', (category, age_range, theme, count))
        
        task_id = cursor.lastrowid
        self.conn.commit()
        
        success_count = 0
        fail_count = 0
        
        for i in range(count):
            print(f"生成第 {i+1}/{count} 个故事...")
            
            try:
                story = self.generate_story(category, age_range, theme)
                if story and self.save_story(story):
                    success_count += 1
                else:
                    fail_count += 1
                    
            except Exception as e:
                print(f"生成故事失败: {e}")
                fail_count += 1
                
            # 小延迟，避免请求过快
            import time
            time.sleep(0.5)
        
        # 更新任务状态
        cursor.execute('''
        UPDATE generation_tasks 
        SET status = 'completed', 
            completed_at = CURRENT_TIMESTAMP,
            success_count = ?,
            fail_count = ?
        WHERE id = ?
        ''', (success_count, fail_count, task_id))
        
        self.conn.commit()
        
        result = {
            "task_id": task_id,
            "success_count": success_count,
            "fail_count": fail_count,
            "total": count
        }
        
        print(f"批量生成完成: 成功 {success_count}/{count}, 失败 {fail_count}")
        return result
    
    def get_statistics(self) -> Dict:
        """获取统计信息"""
        cursor = self.conn.cursor()
        
        # 总故事数
        cursor.execute('SELECT COUNT(*) FROM stories')
        total_stories = cursor.fetchone()[0]
        
        # 按分类统计
        cursor.execute('''
        SELECT category, COUNT(*) as count 
        FROM stories 
        GROUP BY category 
        ORDER BY count DESC
        ''')
        by_category = dict(cursor.fetchall())
        
        # 按年龄统计
        cursor.execute('''
        SELECT age_range, COUNT(*) as count 
        FROM stories 
        GROUP BY age_range 
        ORDER BY age_range
        ''')
        by_age = dict(cursor.fetchall())
        
        # 词数统计
        cursor.execute('SELECT AVG(word_count), MIN(word_count), MAX(word_count) FROM stories')
        avg_words, min_words, max_words = cursor.fetchone()
        
        return {
            "total_stories": total_stories,
            "by_category": by_category,
            "by_age": by_age,
            "word_stats": {
                "average": round(avg_words or 0, 1),
                "min": min_words or 0,
                "max": max_words or 0
            }
        }
    
    def export_stories(self, format: str = "json", output_file: str = None):
        """导出故事"""
        cursor = self.conn.cursor()
        cursor.execute('''
        SELECT id, title, content, category, age_range, theme, length, word_count, tags, created_at
        FROM stories
        ORDER BY id
        ''')
        
        stories = []
        for row in cursor.fetchall():
            story = {
                "id": row[0],
                "title": row[1],
                "content": row[2],
                "category": row[3],
                "age_range": row[4],
                "theme": row[5],
                "length": row[6],
                "word_count": row[7],
                "tags": json.loads(row[8]) if row[8] else [],
                "created_at": row[9]
            }
            stories.append(story)
        
        if format == "json":
            if not output_file:
                output_file = f"stories_export_{datetime.now().strftime('%Y%m%d_%H%M%S')}.json"
            
            with open(output_file, 'w', encoding='utf-8') as f:
                json.dump({
                    "metadata": {
                        "exported_at": datetime.now().isoformat(),
                        "total_stories": len(stories),
                        "version": "1.0"
                    },
                    "stories": stories
                }, f, ensure_ascii=False, indent=2)
            
            print(f"已导出 {len(stories)} 个故事到 {output_file}")
            
        elif format == "sql":
            # 导出为SQL插入语句
            if not output_file:
                output_file = f"stories_export_{datetime.now().strftime('%Y%m%d_%H%M%S')}.sql"
            
            with open(output_file, 'w', encoding='utf-8') as f:
                f.write("-- 小墩子故事屋 - 故事数据导出\n")
                f.write(f"-- 导出时间: {datetime.now().isoformat()}\n")
                f.write(f"-- 故事总数: {len(stories)}\n\n")
                
                for story in stories:
                    # 转义单引号
                    content_escaped = story["content"].replace("'", "''")
                    title_escaped = story["title"].replace("'", "''")
                    tags_escaped = json.dumps(story["tags"], ensure_ascii=False).replace("'", "''")
                    
                    f.write(f"INSERT INTO stories (title, content, category, age_range, theme, length, word_count, tags) VALUES (\n")
                    f.write(f"  '{title_escaped}',\n")
                    f.write(f"  '{content_escaped}',\n")
                    f.write(f"  '{story['category']}',\n")
                    f.write(f"  '{story['age_range']}',\n")
                    f.write(f"  '{story['theme']}',\n")
                    f.write(f"  '{story['length']}',\n")
                    f.write(f"  {story['word_count']},\n")
                    f.write(f"  '{tags_escaped}'\n")
                    f.write(f");\n\n")
            
            print(f"已导出 {len(stories)} 个故事到 {output_file} (SQL格式)")
        
        else:
            print(f"不支持的导出格式: {format}")

class MockStoryGenerator(StoryGenerator):
    """模拟故事生成器（用于测试）"""
    
    def __init__(self, config: Dict):
        super().__init__(config)
        
        # 故事模板
        self.templates = {
            "通话故事": [
                "有一天，{character}给{friend}打电话说：'{dialogue}'。他们聊了很久，最后{character}学会了{lesson}。",
                "{character}想邀请{friend}来家里玩，于是打电话说：'{invitation}'。{friend}很高兴地答应了，他们一起度过了快乐的一天。"
            ],
            "绘本故事": [
                "在{place}，住着一只可爱的{animal}。它喜欢{activity}，每天都会{action}。有一天，它发现了{discovery}，从此生活变得更加{adjective}。",
                "{character}有一本神奇的绘本，每次打开都会进入不同的世界。今天，它来到了{world}，遇到了{friend}，一起经历了{adventure}。"
            ],
            "睡前故事": [
                "夜晚，{character}躺在床上，看着窗外的{object}。{character}想着{thought}，慢慢地闭上了眼睛，进入了甜甜的梦乡。",
                "月亮婆婆温柔地对{character}说：'{message}'。{character}点点头，抱着{object}，安心地睡着了。"
            ],
            "成语故事": [
                "从前，有个人{action}，结果{consequence}。这个故事告诉我们：{moral}。",
                "{character}总是{behavior}，有一天{event}发生了。从此以后，{character}明白了{lesson}。"
            ],
            "寓言故事": [
                "森林里，{animal1}和{animal2}是好朋友。{animal1}喜欢{activity1}，而{animal2}喜欢{activity2}。有一天，{event}发生了，它们学会了{lesson}。",
                "{character}因为{flaw}遇到了麻烦。在{helper}的帮助下，{character}改正了错误，成为了更好的自己。"
            ],
            "科普故事": [
                "{character}对{science_topic}很好奇。通过{method}，{character}发现了{discovery}，明白了{science_fact}。",
                "今天，{character}要带我们去探索{place}。在这里，我们可以看到{observation}，学习到{knowledge}。"
            ]
        }
        
        # 词汇库
        self.vocabulary = {
            "character": ["小明", "小红", "小华", "小丽", "宝宝", "贝贝", "乐乐", "豆豆"],
            "friend": ["好朋友", "小伙伴", "同学", "邻居"],
            "animal": ["小兔子", "小熊", "小松鼠", "小鸟", "小猫", "小狗"],
            "place": ["森林里", "花园中", "小河边", "山坡上", "田野间"],
            "activity": ["唱歌", "跳舞", "画画", "玩游戏", "讲故事"],
            "action": ["快乐地奔跑", "认真地学习", "开心地玩耍", "仔细地观察"],
            "discovery": ["一朵美丽的花", "一颗闪亮的石头", "一个神秘的洞穴", "一片金色的叶子"],
            "adjective": ["有趣", "美好", "神奇", "快乐"],
            "world": ["彩虹王国", "星星城堡", "云朵乐园", "糖果世界"],
            "adventure": ["一次奇妙的旅行", "一场有趣的游戏", "一段美好的友谊", "一个重要的发现"],
            "object": ["星星", "月亮", "云朵", "风"],
            "thought": ["明天的冒险", "今天学到的知识", "远方的朋友", "美好的梦想"],
            "message": ["晚安，好孩子", "做个甜甜的梦", "明天又是美好的一天", "星星会守护你的梦"],
            "behavior": ["骄傲自大", "懒惰贪玩", "自私小气", "粗心大意"],
            "event": ["一场大雨", "一阵大风", "一次比赛", "一个重要任务"],
            "lesson": ["团结合作", "勤奋努力", "分享快乐", "认真仔细"],
            "animal1": ["勤劳的蚂蚁", "聪明的狐狸", "勇敢的狮子", "善良的小鹿"],
            "animal2": ["快乐的蝴蝶", "悠闲的乌龟", "敏捷的猴子", "温柔的大象"],
            "activity1": ["收集食物", "思考问题", "保护家园", "帮助朋友"],
            "activity2": ["翩翩起舞", "慢慢散步", "攀爬树木", "喷水玩耍"],
            "flaw": ["太骄傲", "太懒惰", "太自私", "太粗心"],
            "helper": ["智慧的老树", "善良的仙女", "经验丰富的老师", "热心的朋友"],
            "science_topic": ["彩虹的形成", "雨水的循环", "植物的生长", "动物的习性"],
            "method": ["观察实验", "查阅书籍", "请教老师", "动手实践"],
            "science_fact": ["彩虹是阳光和雨滴的魔法", "雨水会蒸发变成云", "植物需要阳光和水", "动物各有各的特点"],
            "observation": ["各种奇妙的生物", "大自然的规律", "科学的奥秘", "生命的奇迹"],
            "knowledge": ["自然的知识", "科学的道理", "生活的智慧", "世界的奥秘"],
            "dialogue": ["你好吗？我今天学会了一个新游戏", "我们来一起玩吧，我有个好主意", "谢谢你上次帮助我，你真是我的好朋友", "我有一个秘密要告诉你"],
            "invitation": "今天天气真好，要不要来我家玩？我准备了好吃的点心和有趣的玩具",
            "consequence": "大家都笑他太着急", "他明白了做事要有耐心", "他收获了宝贵的经验", "他成为了大家的榜样",
            "moral": "欲速则不达", "团结就是力量", "诚实最可贵", "勤能补拙"
        }
    
    def generate_story(self, category: str, age_range: str, theme: str) -> Optional[Dict]:
        """生成单个故事"""
        
        # 选择模板
        template = random.choice(self.templates[category])
        
        # 填充模板
        story_content = template
        for key, values in self.vocabulary.items():
            placeholder = "{" + key + "}"
            if placeholder in story_content:
                story_content = story_content.replace(placeholder, random.choice(values), 1)
        
        # 根据年龄调整长度
        length_hint = self.config["story_lengths"][age_range]
        
        # 生成标题
        title_templates = [
            f"{theme}的故事",
            f"{random.choice(self.vocabulary['character'])}的{theme}冒险",
            f"{theme}小课堂",
            f"{random.choice(self.vocabulary['animal'])}和{theme}"
        ]
        title = random.choice(title_templates)
        
        # 添加开头和结尾
        full_content = f"{title}\n\n{story_content}\n\n"
        
        # 根据年龄添加不同的结尾
        if age_range == "3-4":
            full_content += f"小朋友，这个故事告诉我们：要{theme}哦！"
        elif age_range == "4-5":
            full_content += f"通过这个故事，我们学到了{theme}的重要性。"
        else:  # 5-6
            full_content += f"这个故事让我们明白：{theme}是一种美好的品质，能让我们更快乐地成长。"
        
        # 生成标签
        tags = [category, age_range, theme]
        if random.random() > 0.5:
            tags.append("动物故事")
        if random.random() > 0.5:
            tags.append("友谊")
        if random.random() > 0.5:
            tags.append("学习")
        
        return {
            "title": title,
            "content": full_content,
            "category": category,
            "age_range": age_range,
            "theme": theme,
            "length": length_hint,
            "tags": tags
        }

class OpenAIGenerator(StoryGenerator):
    """OpenAI故事生成器"""
    
    def __init__(self, config: Dict, api_key: str):
        super().__init__(config)
        self.api_key = api_key
        
        try:
            import openai
            self.openai = openai
            self.openai.api_key = api_key
        except ImportError:
            print("请安装openai库: pip install openai")
            raise
        
    def generate_story(self, category: str, age_range: str, theme: str) -> Optional[Dict]:
        """使用OpenAI生成故事"""
        
        # 构建提示词
        prompt = self.build_prompt(category, age_range, theme)
        
        try:
            response = self.openai.ChatCompletion.create(
                model="gpt-3.5-turbo",
                messages=[
                    {
                        "role": "system",
                        "content": "你是一位优秀的儿童故事作家，擅长创作适合3-6岁儿童的生动有趣、富有教育意义的故事。"
                    },
                    {
                        "role": "user",
                        "content": prompt
                    }
                ],
                temperature=0.7,
                max_tokens=800
            )
            
            story_text = response.choices[0].message.content
            
            # 解析故事（假设第一行是标题）
            lines = story_text.strip().split('\n')
            title = lines[0] if lines else f"{theme}的故事"
            content = '\n'.join(lines[1:]) if len(lines) > 1 else story_text
            
            # 清理标题
            title = title.replace('#', '').replace('**', '').strip()
            
            return {
                "title": title,
                "content": content,
                "category": category,
                "age_range": age_range,
                "theme": theme,
                "length": self.config["story_lengths"][age_range],
                "tags": [category, age_range, theme, "AI生成"]
            }
            
        except Exception as e:
            print(f"OpenAI API调用失败: {e}")
            return None
    
    def build_prompt(self, category: str, age_range: str, theme: str) -> str:
        """构建OpenAI提示词"""
        
        age_map = {
            "3-4": "3到4岁",
            "4-5": "4到5岁", 
            "5-6": "5到6岁"
        }
        
        category_desc = {
            "通话故事": "以对话形式为主的故事",
            "绘本故事": "适合配上图画的故事",
            "睡前故事": "温馨舒缓的睡前故事",
            "成语故事": "解释成语含义的故事",
            "寓言故事": "有教育意义的寓言故事",
            "科普故事": "普及科学知识的故事"
        }
        
        return f"""请为{age_map[age_range]}的儿童创作一个{category_desc[category]}，主题是"{theme}"。

具体要求：
1. 故事要生动有趣，适合儿童理解
2. 语言简单明了，避免复杂词汇
3. 故事要有积极向上的教育意义
4. 长度大约{self.config["story_lengths"][age_range]}
5. 第一行是故事标题
6. 故事内容从第二行开始

请直接创作故事，不需要额外的说明。"""

def main():
    """主函数"""
    import argparse
    
    parser = argparse.ArgumentParser(description="小墩子故事屋 - AI故事生成脚本")
    parser.add_argument("--mode", choices=["mock", "openai"], default="mock", 
                       help="生成模式：mock（模拟）或 openai（使用OpenAI）")
    parser.add_argument("--category", choices=CONFIG["categories"], 
                       help="故事分类")
    parser.add_argument("--age", choices=CONFIG["age_ranges"], default="3-4",
                       help="年龄范围")
    parser.add_argument("--theme", help="故事主题")
    parser.add_argument("--count", type=int, default=1, help="生成数量")
    parser.add_argument("--api-key", help="OpenAI API密钥（openai模式需要）")
    parser.add_argument("--stats", action="store_true", help="显示统计信息")
    parser.add_argument("--export", choices=["json", "sql"], help="导出故事")
    parser.add_argument("--output", help="导出文件名")
    
    args = parser.parse_args()
    
    # 初始化生成器
    if args.mode == "openai":
        if not args.api_key:
            print("错误：openai模式需要 --api-key 参数")
            return
        generator = OpenAIGenerator(CONFIG, args.api_key)
    else:
        generator = MockStoryGenerator(CONFIG)
    
    # 显示统计信息
    if args.stats:
        stats = generator.get_statistics()
        print("\n=== 故事库统计 ===")
        print(f"总故事数: {stats['total_stories']}")
        print(f"\n按分类分布:")
        for category, count in stats['by_category'].items():
            print(f"  {category}: {count}")
        print(f"\n按年龄分布:")
        for age_range, count in stats['by_age'].items():
            print(f"  {age_range}: {count}")
        print(f"\n词数统计:")
        print(f"  平均: {stats['word_stats']['average']} 词")
        print(f"  最少: {stats['word_stats']['min']} 词")
        print(f"  最多: {stats['word_stats']['max']} 词")
        return
    
    # 导出故事
    if args.export:
        generator.export_stories(args.export, args.output)
        return
    
    # 生成故事
    if not args.category:
        print("错误：需要指定 --category 参数")
        return
    
    if not args.theme:
        # 从配置中随机选择主题
        themes = CONFIG["themes"].get(args.category, ["友谊", "学习", "成长"])
        args.theme = random.choice(themes)
        print(f"未指定主题，随机选择: {args.theme}")
    
    print(f"开始生成故事...")
    print(f"模式: {args.mode}")
    print(f"分类: {args.category}")
    print(f"年龄: {args.age}")
    print(f"主题: {args.theme}")
    print(f"数量: {args.count}")
    
    result = generator.batch_generate(args.category, args.age, args.theme, args.count)
    
    print(f"\n生成完成!")
    print(f"任务ID: {result['task_id']}")
    print(f"成功: {result['success_count']}")
    print(f"失败: {result['fail_count']}")
    print(f"总计: {result['total']}")

if __name__ == "__main__":
    main()