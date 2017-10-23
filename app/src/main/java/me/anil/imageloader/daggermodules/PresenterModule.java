package me.anil.imageloader.daggermodules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import me.anil.imageloader.BuildConfig;
import me.anil.imageloader.modules.homescreen.HomeScreenPresenter;
import me.anil.imageloader.network.RestClient;


@Module
public class PresenterModule {

    @Provides
    @Singleton
    HomeScreenPresenter provideHomeScreenPresenter(RestClient restClient) {
        return new HomeScreenPresenter(restClient);
    }

    @Provides
    @Singleton
    RestClient provideRestClient() {
        return new RestClient(BuildConfig.HOST_API);
    }

}
