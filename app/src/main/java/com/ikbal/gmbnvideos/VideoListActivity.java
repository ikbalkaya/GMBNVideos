package com.ikbal.gmbnvideos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.ikbal.gmbnvideos.api.YoutubeApiService;
import com.ikbal.gmbnvideos.api.YoutubeVideo;

import java.util.List;

public class VideoListActivity extends AppCompatActivity {
    private RecyclerView videosRecyclerView;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        videosRecyclerView = findViewById(R.id.videosRecyclerView);
        layoutManager = new LinearLayoutManager(this);
        videosRecyclerView.setLayoutManager(layoutManager);


    }

    @Override
    protected void onStart() {
        super.onStart();
        YoutubeApiService apiService = new YoutubeApiService();
        apiService.listChannelVideos(this::videosReceived,this::errorReceivingVideos);

    }

    private void errorReceivingVideos(String errorMessage) {
    }

    private void videosReceived(List<YoutubeVideo> videos) {
        final VideosRecyclerViewAdapter adapter = new VideosRecyclerViewAdapter(videos);
        videosRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this::onVideoItemClick);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    private void onVideoItemClick(YoutubeVideo video) {
        startActivity(new Intent(this,VideoDetailActivity.class));
    }



}
