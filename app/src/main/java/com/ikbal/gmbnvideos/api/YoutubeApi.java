package com.ikbal.gmbnvideos.api;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface YoutubeApi {
    /**
     * https://www.googleapis.com/youtube/v3/search?part=snippet&key=AIzaSyBsYcWwb_wp7CPjQNvvDPYIbswM8_ZLvZw&channelId=UC_A--fhX5gea0i4UtpD99Gg&fields=items(id,snippet/title,snippet/thumbnails)
     */
    @GET("search?key="+ApiConstants.API_KEY+"&channelId="+ApiConstants.CHANNEL_ID+
            "&part=snippet&fields="+ApiConstants.SEARCH_FIELDS+"&order=date")
    Call<YoutubeVideoResponse> listChannelVideos();

    @GET("videos?key="+ApiConstants.API_KEY+"&part=snippet,contentDetails")
    Call<YoutubeVideoResponse> videoById(@Query("id")String id);
}
