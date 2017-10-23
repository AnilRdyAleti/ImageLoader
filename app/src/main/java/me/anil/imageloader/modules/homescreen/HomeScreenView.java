package me.anil.imageloader.modules.homescreen;

import java.util.ArrayList;

import me.anil.imageloader.base.BaseView;
import me.anil.imageloader.repository.FeedResponse;

public interface HomeScreenView extends BaseView {

    void populateImages(ArrayList<FeedResponse> images);
    void showWarning();
}
