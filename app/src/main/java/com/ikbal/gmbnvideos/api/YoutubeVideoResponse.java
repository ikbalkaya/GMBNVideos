package com.ikbal.gmbnvideos.api;

import android.provider.MediaStore;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YoutubeVideoResponse {
    @SerializedName("items")
    private List<YoutubeVideo> videos;

    public List<YoutubeVideo> getVideos() {
        return videos;
    }
}
