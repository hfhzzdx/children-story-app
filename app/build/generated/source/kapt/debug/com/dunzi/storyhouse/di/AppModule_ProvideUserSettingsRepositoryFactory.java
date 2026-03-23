package com.dunzi.storyhouse.di;

import com.dunzi.storyhouse.data.database.StoryDatabase;
import com.dunzi.storyhouse.data.repository.UserSettingsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideUserSettingsRepositoryFactory implements Factory<UserSettingsRepository> {
  private final Provider<StoryDatabase> databaseProvider;

  public AppModule_ProvideUserSettingsRepositoryFactory(Provider<StoryDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public UserSettingsRepository get() {
    return provideUserSettingsRepository(databaseProvider.get());
  }

  public static AppModule_ProvideUserSettingsRepositoryFactory create(
      Provider<StoryDatabase> databaseProvider) {
    return new AppModule_ProvideUserSettingsRepositoryFactory(databaseProvider);
  }

  public static UserSettingsRepository provideUserSettingsRepository(StoryDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUserSettingsRepository(database));
  }
}
