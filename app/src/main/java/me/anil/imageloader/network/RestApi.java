package me.anil.imageloader.network;

import java.util.ArrayList;

import me.anil.imageloader.repository.FeedResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;


public interface RestApi {



    @GET("/list") // https://picsum.photos/v1/list
    Observable<ArrayList<FeedResponse>> getAllImages();

    @GET("{width}/{height}")
    Observable<FeedResponse> getSelectedImage(@Path("width") int width, @Path("height") int height, @Query("image") int id);


}
