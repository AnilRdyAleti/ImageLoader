package me.anil.imageloader.daggermodules;

import javax.inject.Singleton;

import dagger.Component;
import me.anil.imageloader.context.AppContext;
import me.anil.imageloader.modules.detail.DetailActivity;
import me.anil.imageloader.modules.homescreen.HomeScreenActivity;

@Singleton
@Component(modules = {PresenterModule.class})
public interface ObjectGraph {


    final class Builder {

        public static ObjectGraph build(AppContext application) {

            return DaggerObjectGraph.builder()
                    .presenterModule(new PresenterModule())
                    .build();

        }

    }


    void inject(HomeScreenActivity homeScreenActivity);


    void inject(DetailActivity detailActivity);


}
