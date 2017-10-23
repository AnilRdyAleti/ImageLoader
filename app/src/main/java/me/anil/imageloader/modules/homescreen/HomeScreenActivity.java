package me.anil.imageloader.modules.homescreen;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.anil.imageloader.R;
import me.anil.imageloader.context.AppContext;
import me.anil.imageloader.repository.FeedResponse;

public class HomeScreenActivity extends AppCompatActivity implements HomeScreenView, SwipeRefreshLayout.OnRefreshListener {


    @Inject
    HomeScreenPresenter homeScreenPresenter;


    @BindView(R.id.home_screen_tablayout)
    TabLayout tabLayout;


    @BindView(R.id.home_screen_toolbar)
    Toolbar toolbar;


    @BindView(R.id.fragment_swipe_refresh_view)
    SwipeRefreshLayout swipeRefreshLayout;

    @BindView(R.id.images_recyclerview)
    RecyclerView recyclerView;


    private ProgressDialog mProgressDialog;

    private GridLayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        AppContext.graph(this).inject(this);
        ButterKnife.bind(this);
        swipeRefreshLayout.setOnRefreshListener(this);

        homeScreenPresenter.attachView(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.toolbar_title);

        layoutManager = new GridLayoutManager(this, 2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

    }


    @Override
    protected void onStop() {
        super.onStop();
        homeScreenPresenter.detachView();
    }

    @Override
    public void showProgressDialog() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setTitle(getString(R.string.progress_title));
        mProgressDialog.setMessage(getString(R.string.progress_message));
        mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mProgressDialog.show();

    }

    @Override
    public void hideProgressDialog() {


        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
            mProgressDialog = null;
            swipeRefreshLayout.setRefreshing(false);
        }

    }

    @Override
    public void onError(Throwable throwable) {
        Snackbar.make(findViewById(android.R.id.content), R.string.snackbar_error, Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void onRefresh() {
        homeScreenPresenter.getAllImages();
    }

    @Override
    public void populateImages(ArrayList<FeedResponse> images) {

        setupRecyclerView(images);
        swipeRefreshLayout.setRefreshing(false);

    }

    @Override
    public void showWarning() {
        //todo snackbar..
    }

    public void setupRecyclerView(ArrayList<FeedResponse> imagesResponse) {

        ImageAdapter imageAdapter = new ImageAdapter(this, imagesResponse);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(imageAdapter);

    }
}
