package com.dunzi.storyhouse.di;

import com.dunzi.storyhouse.data.database.StoryDatabase;
import com.dunzi.storyhouse.data.repository.StoryRepository;
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
public final class AppModule_ProvideStoryRepositoryFactory implements Factory<StoryRepository> {
  private final Provider<StoryDatabase> databaseProvider;

  public AppModule_ProvideStoryRepositoryFactory(Provider<StoryDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public StoryRepository get() {
    return provideStoryRepository(databaseProvider.get());
  }

  public static AppModule_ProvideStoryRepositoryFactory create(
      Provider<StoryDatabase> databaseProvider) {
    return new AppModule_ProvideStoryRepositoryFactory(databaseProvider);
  }

  public static StoryRepository provideStoryRepository(StoryDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideStoryRepository(database));
  }
}
