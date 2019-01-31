package com.ikbal.gmbnvideos;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

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
        final VideosRecyclerViewAdapter adapter = new VideosRecyclerViewAdapter();
        videosRecyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(this::onVideoItemClick);



    }

    private void onVideoItemClick(int position) {
        startActivity(new Intent(this,VideoDetailActivity.class));
    }


}
