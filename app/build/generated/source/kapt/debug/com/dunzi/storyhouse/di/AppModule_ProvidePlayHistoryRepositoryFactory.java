package com.dunzi.storyhouse.di;

import com.dunzi.storyhouse.data.database.StoryDatabase;
import com.dunzi.storyhouse.data.repository.PlayHistoryRepository;
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
public final class AppModule_ProvidePlayHistoryRepositoryFactory implements Factory<PlayHistoryRepository> {
  private final Provider<StoryDatabase> databaseProvider;

  public AppModule_ProvidePlayHistoryRepositoryFactory(Provider<StoryDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public PlayHistoryRepository get() {
    return providePlayHistoryRepository(databaseProvider.get());
  }

  public static AppModule_ProvidePlayHistoryRepositoryFactory create(
      Provider<StoryDatabase> databaseProvider) {
    return new AppModule_ProvidePlayHistoryRepositoryFactory(databaseProvider);
  }

  public static PlayHistoryRepository providePlayHistoryRepository(StoryDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.providePlayHistoryRepository(database));
  }
}
