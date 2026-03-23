package com.dunzi.storyhouse.di;

import android.content.Context;
import com.dunzi.storyhouse.data.database.StoryDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideStoryDatabaseFactory implements Factory<StoryDatabase> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideStoryDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public StoryDatabase get() {
    return provideStoryDatabase(contextProvider.get());
  }

  public static AppModule_ProvideStoryDatabaseFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideStoryDatabaseFactory(contextProvider);
  }

  public static StoryDatabase provideStoryDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideStoryDatabase(context));
  }
}
