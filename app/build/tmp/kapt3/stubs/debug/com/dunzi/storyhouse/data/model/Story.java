package com.dunzi.storyhouse.data.model;

/**
 * 故事实体类
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\bO\b\u0087\b\u0018\u00002\u00020\u0001B\u00c1\u0002\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001f\u001a\u00020 \u0012\b\b\u0002\u0010!\u001a\u00020 \u0012\b\b\u0002\u0010\"\u001a\u00020 \u0012\b\b\u0002\u0010#\u001a\u00020 \u0012\b\b\u0002\u0010$\u001a\u00020\u0003\u0012\b\b\u0002\u0010%\u001a\u00020\u001a\u0012\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\'\u00a2\u0006\u0002\u0010(J\t\u0010K\u001a\u00020\u0003H\u00c6\u0003J\t\u0010L\u001a\u00020\u0005H\u00c6\u0003J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\u0011H\u00c6\u0003J\t\u0010O\u001a\u00020\u0011H\u00c6\u0003J\t\u0010P\u001a\u00020\u0011H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0005H\u00c6\u0003J\t\u0010R\u001a\u00020\u0005H\u00c6\u0003J\t\u0010S\u001a\u00020\u0005H\u00c6\u0003J\t\u0010T\u001a\u00020\u0011H\u00c6\u0003J\t\u0010U\u001a\u00020\u0011H\u00c6\u0003J\t\u0010V\u001a\u00020\u0005H\u00c6\u0003J\t\u0010W\u001a\u00020\u001aH\u00c6\u0003J\t\u0010X\u001a\u00020\u001cH\u00c6\u0003J\t\u0010Y\u001a\u00020\u001cH\u00c6\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u001cH\u00c6\u0003J\t\u0010[\u001a\u00020 H\u00c6\u0003J\t\u0010\\\u001a\u00020 H\u00c6\u0003J\t\u0010]\u001a\u00020 H\u00c6\u0003J\t\u0010^\u001a\u00020 H\u00c6\u0003J\t\u0010_\u001a\u00020\u0003H\u00c6\u0003J\t\u0010`\u001a\u00020\u001aH\u00c6\u0003J\t\u0010a\u001a\u00020\u0005H\u00c6\u0003J\u0015\u0010b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\'H\u00c6\u0003J\t\u0010c\u001a\u00020\u0005H\u00c6\u0003J\t\u0010d\u001a\u00020\u0005H\u00c6\u0003J\t\u0010e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010f\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010g\u001a\b\u0012\u0004\u0012\u00020\u00050\fH\u00c6\u0003J\t\u0010h\u001a\u00020\u0005H\u00c6\u0003J\u00c9\u0002\u0010i\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f2\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00052\b\b\u0002\u0010\u0015\u001a\u00020\u00052\b\b\u0002\u0010\u0016\u001a\u00020\u00052\b\b\u0002\u0010\u0017\u001a\u00020\u00112\b\b\u0002\u0010\u0018\u001a\u00020\u00112\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001c2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020 2\b\b\u0002\u0010\"\u001a\u00020 2\b\b\u0002\u0010#\u001a\u00020 2\b\b\u0002\u0010$\u001a\u00020\u00032\b\b\u0002\u0010%\u001a\u00020\u001a2\u0014\b\u0002\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\'H\u00c6\u0001J\u0013\u0010j\u001a\u00020 2\b\u0010k\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u0006\u0010l\u001a\u00020\u0005J\u0006\u0010m\u001a\u00020\u0005J\f\u0010n\u001a\b\u0012\u0004\u0012\u00020\u00050\fJ\u0006\u0010o\u001a\u00020\u0011J\u0006\u0010p\u001a\u00020 J\u0006\u0010q\u001a\u00020 J\t\u0010r\u001a\u00020\u0011H\u00d6\u0001J\u000e\u0010s\u001a\u00020 2\u0006\u0010t\u001a\u00020\u0011J\t\u0010u\u001a\u00020\u0005H\u00d6\u0001R\u0011\u0010\u000e\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u0011\u0010\t\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010*R\u0011\u0010\r\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010*R\u0011\u0010\b\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010*R\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010*R\u0011\u0010\u000f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0011\u0010\u0018\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0011\u0010\u0016\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010*R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0011\u0010\"\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u00108R\u0011\u0010!\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b!\u00108R\u0011\u0010\u001f\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u00108R\u0011\u0010#\u001a\u00020 \u00a2\u0006\b\n\u0000\u001a\u0004\b#\u00108R\u0011\u0010\u0014\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010*R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u00100R\u0011\u0010$\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u0011\u0010\u0013\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u00105R\u001d\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\'\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010>R\u0011\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b?\u00105R\u0011\u0010\u0017\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u00105R\u0011\u0010%\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010BR\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\bC\u0010BR\u0011\u0010\u0015\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010*R\u0011\u0010\n\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010*R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\f\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010GR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\bH\u0010*R\u0011\u0010\u001d\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\bI\u00100R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u00105\u00a8\u0006v"}, d2 = {"Lcom/dunzi/storyhouse/data/model/Story;", "", "id", "", "title", "", "author", "description", "coverImage", "category", "subCategory", "tags", "", "contentPath", "audioPath", "duration", "wordCount", "", "minAge", "maxAge", "language", "source", "format", "playCount", "favoriteCount", "rating", "", "createdAt", "Ljava/util/Date;", "updatedAt", "lastPlayedAt", "isFavorite", "", "isDownloaded", "isCompleted", "isHidden", "lastPosition", "progress", "metadata", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;JIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;IIFLjava/util/Date;Ljava/util/Date;Ljava/util/Date;ZZZZJFLjava/util/Map;)V", "getAudioPath", "()Ljava/lang/String;", "getAuthor", "getCategory", "getContentPath", "getCoverImage", "getCreatedAt", "()Ljava/util/Date;", "getDescription", "getDuration", "()J", "getFavoriteCount", "()I", "getFormat", "getId", "()Z", "getLanguage", "getLastPlayedAt", "getLastPosition", "getMaxAge", "getMetadata", "()Ljava/util/Map;", "getMinAge", "getPlayCount", "getProgress", "()F", "getRating", "getSource", "getSubCategory", "getTags", "()Ljava/util/List;", "getTitle", "getUpdatedAt", "getWordCount", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "getAgeRange", "getDurationString", "getMainTags", "getProgressPercentage", "hasAudio", "hasContent", "hashCode", "isSuitableForAge", "age", "toString", "app_debug"})
@androidx.room.Entity(tableName = "stories")
@androidx.room.TypeConverters(value = {com.dunzi.storyhouse.data.converter.DateConverter.class, com.dunzi.storyhouse.data.converter.ListConverter.class})
public final class Story {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String author = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String coverImage = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String category = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String subCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> tags = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String contentPath = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String audioPath = null;
    private final long duration = 0L;
    private final int wordCount = 0;
    private final int minAge = 0;
    private final int maxAge = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String language = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String source = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String format = null;
    private final int playCount = 0;
    private final int favoriteCount = 0;
    private final float rating = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Date createdAt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Date updatedAt = null;
    @org.jetbrains.annotations.Nullable()
    private final java.util.Date lastPlayedAt = null;
    private final boolean isFavorite = false;
    private final boolean isDownloaded = false;
    private final boolean isCompleted = false;
    private final boolean isHidden = false;
    private final long lastPosition = 0L;
    private final float progress = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.String, java.lang.String> metadata = null;
    
    public Story(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String coverImage, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String subCategory, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull()
    java.lang.String contentPath, @org.jetbrains.annotations.NotNull()
    java.lang.String audioPath, long duration, int wordCount, int minAge, int maxAge, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    java.lang.String format, int playCount, int favoriteCount, float rating, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, @org.jetbrains.annotations.Nullable()
    java.util.Date lastPlayedAt, boolean isFavorite, boolean isDownloaded, boolean isCompleted, boolean isHidden, long lastPosition, float progress, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> metadata) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAuthor() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCoverImage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSubCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getTags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContentPath() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAudioPath() {
        return null;
    }
    
    public final long getDuration() {
        return 0L;
    }
    
    public final int getWordCount() {
        return 0;
    }
    
    public final int getMinAge() {
        return 0;
    }
    
    public final int getMaxAge() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getLanguage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getSource() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getFormat() {
        return null;
    }
    
    public final int getPlayCount() {
        return 0;
    }
    
    public final int getFavoriteCount() {
        return 0;
    }
    
    public final float getRating() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date getUpdatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date getLastPlayedAt() {
        return null;
    }
    
    public final boolean isFavorite() {
        return false;
    }
    
    public final boolean isDownloaded() {
        return false;
    }
    
    public final boolean isCompleted() {
        return false;
    }
    
    public final boolean isHidden() {
        return false;
    }
    
    public final long getLastPosition() {
        return 0L;
    }
    
    public final float getProgress() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> getMetadata() {
        return null;
    }
    
    /**
     * 获取适合年龄范围字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAgeRange() {
        return null;
    }
    
    /**
     * 获取时长字符串
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDurationString() {
        return null;
    }
    
    /**
     * 获取进度百分比
     */
    public final int getProgressPercentage() {
        return 0;
    }
    
    /**
     * 检查是否适合指定年龄
     */
    public final boolean isSuitableForAge(int age) {
        return false;
    }
    
    /**
     * 检查是否有音频
     */
    public final boolean hasAudio() {
        return false;
    }
    
    /**
     * 检查是否有文本内容
     */
    public final boolean hasContent() {
        return false;
    }
    
    /**
     * 获取主要标签（前3个）
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getMainTags() {
        return null;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    public final long component11() {
        return 0L;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final int component13() {
        return 0;
    }
    
    public final int component14() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component17() {
        return null;
    }
    
    public final int component18() {
        return 0;
    }
    
    public final int component19() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final float component20() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component21() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Date component22() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.Date component23() {
        return null;
    }
    
    public final boolean component24() {
        return false;
    }
    
    public final boolean component25() {
        return false;
    }
    
    public final boolean component26() {
        return false;
    }
    
    public final boolean component27() {
        return false;
    }
    
    public final long component28() {
        return 0L;
    }
    
    public final float component29() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, java.lang.String> component30() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.dunzi.storyhouse.data.model.Story copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String author, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.lang.String coverImage, @org.jetbrains.annotations.NotNull()
    java.lang.String category, @org.jetbrains.annotations.NotNull()
    java.lang.String subCategory, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> tags, @org.jetbrains.annotations.NotNull()
    java.lang.String contentPath, @org.jetbrains.annotations.NotNull()
    java.lang.String audioPath, long duration, int wordCount, int minAge, int maxAge, @org.jetbrains.annotations.NotNull()
    java.lang.String language, @org.jetbrains.annotations.NotNull()
    java.lang.String source, @org.jetbrains.annotations.NotNull()
    java.lang.String format, int playCount, int favoriteCount, float rating, @org.jetbrains.annotations.NotNull()
    java.util.Date createdAt, @org.jetbrains.annotations.NotNull()
    java.util.Date updatedAt, @org.jetbrains.annotations.Nullable()
    java.util.Date lastPlayedAt, boolean isFavorite, boolean isDownloaded, boolean isCompleted, boolean isHidden, long lastPosition, float progress, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, java.lang.String> metadata) {
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