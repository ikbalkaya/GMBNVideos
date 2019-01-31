package com.ikbal.gmbnvideos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

class VideosRecyclerViewAdapter extends RecyclerView.Adapter<VideosRecyclerViewAdapter.VideoViewHolder> {

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video, viewGroup, false);

        VideoViewHolder videoViewHolder = new VideoViewHolder(itemView);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        videoViewHolder.videoTitleTextView.setText("Video number "+(i+1));
        Picasso.get().load("https://img.youtube.com/vi/JOlc0a2eVTo/sddefault.jpg")
                .placeholder(R.drawable.video_placeholder)
                .into(videoViewHolder.videoImageView);

    }

    @Override
    public int getItemCount() {
        return 88;
    }

    class VideoViewHolder extends RecyclerView.ViewHolder{
        ImageView videoImageView;
        TextView videoTitleTextView;
        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoImageView = itemView.findViewById(R.id.videoImageView);
            videoTitleTextView = itemView.findViewById(R.id.videoTitleView);
        }
    }
}
