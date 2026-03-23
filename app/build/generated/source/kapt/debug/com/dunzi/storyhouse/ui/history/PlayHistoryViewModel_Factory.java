package com.dunzi.storyhouse.ui.history;

import com.dunzi.storyhouse.data.repository.PlayHistoryRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class PlayHistoryViewModel_Factory implements Factory<PlayHistoryViewModel> {
  private final Provider<PlayHistoryRepository> playHistoryRepositoryProvider;

  public PlayHistoryViewModel_Factory(
      Provider<PlayHistoryRepository> playHistoryRepositoryProvider) {
    this.playHistoryRepositoryProvider = playHistoryRepositoryProvider;
  }

  @Override
  public PlayHistoryViewModel get() {
    return newInstance(playHistoryRepositoryProvider.get());
  }

  public static PlayHistoryViewModel_Factory create(
      Provider<PlayHistoryRepository> playHistoryRepositoryProvider) {
    return new PlayHistoryViewModel_Factory(playHistoryRepositoryProvider);
  }

  public static PlayHistoryViewModel newInstance(PlayHistoryRepository playHistoryRepository) {
    return new PlayHistoryViewModel(playHistoryRepository);
  }
}
