package com.ikbal.gmbnvideos.api;

import android.support.annotation.NonNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class YoutubeApiService {
    public interface ApiSuccessListener {
        void onVideos(List<YoutubeVideo> videos);
    }

    public interface SearchFailedListener {
        void onFail(String failMessage);
    }

    public void listChannelVideos(@NonNull ApiSuccessListener successListener,
                                  @NonNull SearchFailedListener failedListener) {
        final YoutubeApi apiRef = apiRef();
        final Call<YoutubeVideoResponse> searchCall = apiRef.listChannelVideos();
        doCall(successListener, failedListener, searchCall);

    }
    public void getVideo(String videoId,@NonNull ApiSuccessListener successListener,
                                  @NonNull SearchFailedListener failedListener) {
        final YoutubeApi apiRef = apiRef();
        final Call<YoutubeVideoResponse> videoCall = apiRef.videoById(videoId);
        doCall(successListener, failedListener, videoCall);
    }

    private void doCall(@NonNull ApiSuccessListener successListener, @NonNull SearchFailedListener failedListener, Call<YoutubeVideoResponse> searchCall) {
        searchCall.enqueue(new Callback<YoutubeVideoResponse>() {
            @Override
            public void onResponse(Call<YoutubeVideoResponse> call, Response<YoutubeVideoResponse> response) {
                if (response.isSuccessful()){
                    final YoutubeVideoResponse videoResponse = response.body();
                    successListener.onVideos(videoResponse.getVideos());
                }else{
                    failedListener.onFail("failed");
                }
            }

            @Override
            public void onFailure(Call<YoutubeVideoResponse> call, Throwable t) {
                 if (!call.isCanceled()){
                     failedListener.onFail(t.getLocalizedMessage());
                 }
            }
        });
    }

    private YoutubeApi apiRef(){
        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(YoutubeApi.class);
    }
}
