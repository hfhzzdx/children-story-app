package com.dunzi.storyhouse.service;

import com.dunzi.storyhouse.data.repository.PlayHistoryRepository;
import com.dunzi.storyhouse.data.repository.StoryRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AudioPlaybackService_MembersInjector implements MembersInjector<AudioPlaybackService> {
  private final Provider<StoryRepository> storyRepositoryProvider;

  private final Provider<PlayHistoryRepository> playHistoryRepositoryProvider;

  public AudioPlaybackService_MembersInjector(Provider<StoryRepository> storyRepositoryProvider,
      Provider<PlayHistoryRepository> playHistoryRepositoryProvider) {
    this.storyRepositoryProvider = storyRepositoryProvider;
    this.playHistoryRepositoryProvider = playHistoryRepositoryProvider;
  }

  public static MembersInjector<AudioPlaybackService> create(
      Provider<StoryRepository> storyRepositoryProvider,
      Provider<PlayHistoryRepository> playHistoryRepositoryProvider) {
    return new AudioPlaybackService_MembersInjector(storyRepositoryProvider, playHistoryRepositoryProvider);
  }

  @Override
  public void injectMembers(AudioPlaybackService instance) {
    injectStoryRepository(instance, storyRepositoryProvider.get());
    injectPlayHistoryRepository(instance, playHistoryRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.dunzi.storyhouse.service.AudioPlaybackService.storyRepository")
  public static void injectStoryRepository(AudioPlaybackService instance,
      StoryRepository storyRepository) {
    instance.storyRepository = storyRepository;
  }

  @InjectedFieldSignature("com.dunzi.storyhouse.service.AudioPlaybackService.playHistoryRepository")
  public static void injectPlayHistoryRepository(AudioPlaybackService instance,
      PlayHistoryRepository playHistoryRepository) {
    instance.playHistoryRepository = playHistoryRepository;
  }
}
