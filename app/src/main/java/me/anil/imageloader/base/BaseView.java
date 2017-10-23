package me.anil.imageloader.base;



public interface BaseView {
    void showProgressDialog();

    void hideProgressDialog();

    void onError(Throwable throwable);

}
