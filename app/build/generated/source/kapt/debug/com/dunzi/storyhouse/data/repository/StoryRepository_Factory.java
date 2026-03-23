package com.dunzi.storyhouse.data.repository;

import com.dunzi.storyhouse.data.database.StoryDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class StoryRepository_Factory implements Factory<StoryRepository> {
  private final Provider<StoryDatabase> databaseProvider;

  public StoryRepository_Factory(Provider<StoryDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public StoryRepository get() {
    return newInstance(databaseProvider.get());
  }

  public static StoryRepository_Factory create(Provider<StoryDatabase> databaseProvider) {
    return new StoryRepository_Factory(databaseProvider);
  }

  public static StoryRepository newInstance(StoryDatabase database) {
    return new StoryRepository(database);
  }
}
