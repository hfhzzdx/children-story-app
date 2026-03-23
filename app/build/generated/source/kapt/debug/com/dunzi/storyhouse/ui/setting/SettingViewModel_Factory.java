package com.dunzi.storyhouse.ui.setting;

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
public final class SettingViewModel_Factory implements Factory<SettingViewModel> {
  private final Provider<UserSettingsRepository> userSettingsRepositoryProvider;

  public SettingViewModel_Factory(Provider<UserSettingsRepository> userSettingsRepositoryProvider) {
    this.userSettingsRepositoryProvider = userSettingsRepositoryProvider;
  }

  @Override
  public SettingViewModel get() {
    return newInstance(userSettingsRepositoryProvider.get());
  }

  public static SettingViewModel_Factory create(
      Provider<UserSettingsRepository> userSettingsRepositoryProvider) {
    return new SettingViewModel_Factory(userSettingsRepositoryProvider);
  }

  public static SettingViewModel newInstance(UserSettingsRepository userSettingsRepository) {
    return new SettingViewModel(userSettingsRepository);
  }
}
