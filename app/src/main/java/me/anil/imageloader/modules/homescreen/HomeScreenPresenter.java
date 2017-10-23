package me.anil.imageloader.modules.homescreen;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;

import me.anil.imageloader.base.BasePresenter;
import me.anil.imageloader.network.RestClient;
import me.anil.imageloader.repository.FeedResponse;
import rx.Observable;
import rx.Subscriber;

public class HomeScreenPresenter extends BasePresenter<HomeScreenView> {


    private static final String TAG = "HomeScreenPresenter";
    private RestClient restClient;

    public HomeScreenPresenter(RestClient restClient) {
        this.restClient = restClient;
    }


    void getAllImages() {
        if (view != null)
            view.showProgressDialog();

        final Observable<ArrayList<FeedResponse>> allImages = restClient.createNewApi().getAllImages();
        Subscriber<ArrayList<FeedResponse>> feedObservable = getImageSubscriber();
        addSubscription(allImages, feedObservable);
    }

    @NonNull
    private Subscriber<ArrayList<FeedResponse>> getImageSubscriber() {
        return new Subscriber<ArrayList<FeedResponse>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "onError() called with: e = [" + e + "]");
                view.onError(e);
                view.hideProgressDialog();
            }

            @Override
            public void onNext(ArrayList<FeedResponse> images) {

                view.hideProgressDialog();


                view.populateImages(images);


            }
        };
    }


}
