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
public final class UserSettingsRepository_Factory implements Factory<UserSettingsRepository> {
  private final Provider<StoryDatabase> databaseProvider;

  public UserSettingsRepository_Factory(Provider<StoryDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UserSettingsRepository get() {
    return newInstance(databaseProvider.get());
  }

  public static UserSettingsRepository_Factory create(Provider<StoryDatabase> databaseProvider) {
    return new UserSettingsRepository_Factory(databaseProvider);
  }

  public static UserSettingsRepository newInstance(StoryDatabase database) {
    return new UserSettingsRepository(database);
  }
}
