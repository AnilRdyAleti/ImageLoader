package me.anil.imageloader.modules.homescreen;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;

import me.anil.imageloader.BuildConfig;
import me.anil.imageloader.network.RestClient;
import me.anil.imageloader.repository.FeedResponse;
import rx.observers.TestSubscriber;


@RunWith(MockitoJUnitRunner.class)
public class HomeScreenPresenterTest {


    private HomeScreenPresenter homeScreenPresenter;

    @Mock
    HomeScreenView homeScreenView;
    @Mock
    RestClient restClient;


    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        restClient = new RestClient(BuildConfig.HOST_API);
        homeScreenPresenter.attachView(homeScreenView);
    }

    @Test
    public void getAllNewsFeeds() throws Exception {
        TestSubscriber<ArrayList<FeedResponse>> feedTestSubscriber = new TestSubscriber<>();
        restClient.createNewApi().getAllImages().subscribe(feedTestSubscriber);
        feedTestSubscriber.assertNoErrors();
    }

}