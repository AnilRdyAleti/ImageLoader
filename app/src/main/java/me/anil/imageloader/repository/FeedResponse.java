package me.anil.imageloader.repository;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import io.realm.RealmObject;



public class FeedResponse extends RealmObject implements Serializable,MetaData {


    @SerializedName("format")
    public String format;
    @SerializedName("width")
    public int width;
    @SerializedName("height")
    public int height;
    @SerializedName("filename")
    public String filename;
    @SerializedName("id")
    public int id;
    @SerializedName("author")
    public String author;
    @SerializedName("author_url")
    public String author_url;
    @SerializedName("post_url")
    public String post_url;

    @Override
    public void showAuthor(String author) {

    }

    public void getAuthor() {

    }
}
