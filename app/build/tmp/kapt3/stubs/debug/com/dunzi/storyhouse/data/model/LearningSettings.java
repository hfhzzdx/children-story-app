package com.dunzi.storyhouse.data.model;

/**
 * 学习设置数据类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b \b\u0086\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\rH\u00c6\u0003J\t\u0010!\u001a\u00020\u000fH\u00c6\u0003J\t\u0010\"\u001a\u00020\u0003H\u00c6\u0003J\t\u0010#\u001a\u00020\u0003H\u00c6\u0003J\t\u0010$\u001a\u00020\u0003H\u00c6\u0003J\t\u0010%\u001a\u00020\u0003H\u00c6\u0003J\t\u0010&\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\u0003H\u00c6\u0003Jw\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020\rH\u00d6\u0001J\t\u0010.\u001a\u00020\u000fH\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\f\u001a\u00020\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012\u00a8\u0006/"}, d2 = {"Lcom/dunzi/storyhouse/data/model/LearningSettings;", "", "learningMode", "", "repeatDifficultParts", "showSubtitles", "vocabularyHighlight", "pronunciationPractice", "comprehensionQuestions", "progressTracking", "achievementSystem", "dailyGoals", "dailyGoalMinutes", "", "difficultyLevel", "", "(ZZZZZZZZZILjava/lang/String;)V", "getAchievementSystem", "()Z", "getComprehensionQuestions", "getDailyGoalMinutes", "()I", "getDailyGoals", "getDifficultyLevel", "()Ljava/lang/String;", "getLearningMode", "getProgressTracking", "getPronunciationPractice", "getRepeatDifficultParts", "getShowSubtitles", "getVocabularyHighlight", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "hashCode", "toString", "app_debug"})
public final class LearningSettings {
    private final boolean learningMode = false;
    private final boolean repeatDifficultParts = false;
    private final boolean showSubtitles = false;
    private final boolean vocabularyHighlight = false;
    private final boolean pronunciationPractice = false;
    private final boolean comprehensionQuestions = false;
    private final boolean progressTracking = false;
    private final boolean achievementSystem = false;
    private final boolean dailyGoals = false;
    private final int dailyGoalMinutes = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String difficultyLevel = null;
    
    public LearningSettings(boolean learningMode, boolean repeatDifficultParts, boolean showSubtitles, boolean vocabularyHighlight, boolean pronunciationPractice, boolean comprehensionQuestions, boolean progressTracking, boolean achievementSystem, boolean dailyGoals, int dailyGoalMinutes, @org.jetbrains.annotations.NotNull()
    java.lang.String difficultyLevel) {
        super();
    }
    
    public final boolean getLearningMode() {
        return false;
    }
    
    public final boolean getRepeatDifficultParts() {
        return false;
    }
    
    public final boolean getShowSubtitles() {
        return false;
    }
    
    public final boolean getVocabularyHighlight() {
        return false;
    }
    
    public final boolean getPronunciationPractice() {
        return false;
    }
    
    public final boolean getComprehensionQuestions() {
        return false;
    }
    
    public final boolean getProgressTracking() {
        return false;
    }
    
    public final boolean getAchievementSystem() {
        return false;
    }
    
    public final boolean getDailyGoals() {
        return false;
    }
    
    public final int getDailyGoalMinutes() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDifficultyLevel() {
        return null;
    }
    
    public LearningSettings() {
        super();
    }
    
    public final boolean component1() {
        return false;
    }
    
    public final int component10() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component11() {
        return null;
    }
    
    public final boolean component2() {
        return false;
    }
    
    public final boolean component3() {
        return false;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    public final boolean component6() {
        return false;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final boolean component8() {
        return false;
    }
    
    public final boolean component9() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.model.LearningSettings copy(boolean learningMode, boolean repeatDifficultParts, boolean showSubtitles, boolean vocabularyHighlight, boolean pronunciationPractice, boolean comprehensionQuestions, boolean progressTracking, boolean achievementSystem, boolean dailyGoals, int dailyGoalMinutes, @org.jetbrains.annotations.NotNull()
    java.lang.String difficultyLevel) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}