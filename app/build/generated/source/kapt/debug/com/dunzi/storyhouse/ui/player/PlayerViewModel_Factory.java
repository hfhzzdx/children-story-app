package com.dunzi.storyhouse.ui.player;

import com.dunzi.storyhouse.data.repository.PlayHistoryRepository;
import com.dunzi.storyhouse.data.repository.StoryRepository;
import com.dunzi.storyhouse.data.repository.UserSettingsRepository;
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
public final class PlayerViewModel_Factory implements Factory<PlayerViewModel> {
  private final Provider<StoryRepository> storyRepositoryProvider;

  private final Provider<UserSettingsRepository> userSettingsRepositoryProvider;

  private final Provider<PlayHistoryRepository> playHistoryRepositoryProvider;

  public PlayerViewModel_Factory(Provider<StoryRepository> storyRepositoryProvider,
      Provider<UserSettingsRepository> userSettingsRepositoryProvider,
      Provider<PlayHistoryRepository> playHistoryRepositoryProvider) {
    this.storyRepositoryProvider = storyRepositoryProvider;
    this.userSettingsRepositoryProvider = userSettingsRepositoryProvider;
    this.playHistoryRepositoryProvider = playHistoryRepositoryProvider;
  }

  @Override
  public PlayerViewModel get() {
    return newInstance(storyRepositoryProvider.get(), userSettingsRepositoryProvider.get(), playHistoryRepositoryProvider.get());
  }

  public static PlayerViewModel_Factory create(Provider<StoryRepository> storyRepositoryProvider,
      Provider<UserSettingsRepository> userSettingsRepositoryProvider,
      Provider<PlayHistoryRepository> playHistoryRepositoryProvider) {
    return new PlayerViewModel_Factory(storyRepositoryProvider, userSettingsRepositoryProvider, playHistoryRepositoryProvider);
  }

  public static PlayerViewModel newInstance(StoryRepository storyRepository,
      UserSettingsRepository userSettingsRepository, PlayHistoryRepository playHistoryRepository) {
    return new PlayerViewModel(storyRepository, userSettingsRepository, playHistoryRepository);
  }
}
