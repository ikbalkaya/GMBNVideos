package com.ikbal.gmbnvideos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ikbal.gmbnvideos.api.YoutubeApi;
import com.ikbal.gmbnvideos.api.YoutubeApiService;
import com.ikbal.gmbnvideos.api.YoutubeVideo;
import com.squareup.picasso.Picasso;

import java.util.IllegalFormatCodePointException;
import java.util.List;

public class VideoDetailActivity extends AppCompatActivity {
    public static String EXTRA_VIDEO_ID = "EXTRA_VIDEO_ID";

    private String videoId;
    private TextView titleTextview;
    private ImageView videoImageView;
    private TextView durationTextview;
    private TextView descriptionTextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        videoImageView = findViewById(R.id.videoImageView);
        titleTextview = findViewById(R.id.videoTitleView);
        durationTextview = findViewById(R.id.durationTextView);
        descriptionTextview = findViewById(R.id.descriptionTextView);


        final Bundle extras = getIntent().getExtras();
        if (extras != null){
             videoId = extras.getString(EXTRA_VIDEO_ID);
        }

    }

    private void errorReceivingVideos(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();
    }

    private void videosReceived(List<YoutubeVideo> videos) {
        if (videos.size()>0){
            final YoutubeVideo video = videos.get(0);
            Picasso.get().load(video.getSnippet().getThumbnails().getHigh().getUrl()).into(videoImageView);
            durationTextview.setText(video.getContentDetails().getDuration());

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        YoutubeApiService apiService = new YoutubeApiService();
        apiService.getVideo(videoId,this::videosReceived,this::errorReceivingVideos);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

}
