package me.anil.imageloader.base;

import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;


public class BasePresenter<V extends BaseView> {

    private CompositeSubscription subscriptions = new CompositeSubscription();
    protected V view;


    public void attachView(V view) {
        subscriptions = new CompositeSubscription();
        this.view = view;
    }

    public void detachView() {
        if (subscriptions != null) subscriptions.unsubscribe();
        this.view = null;
    }


    public <T> void addSubscription(Observable<T> observable, Subscriber subscriber) {
        final Subscription subscription = observable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(subscriber);
        subscriptions.add(subscription);
    }
}
