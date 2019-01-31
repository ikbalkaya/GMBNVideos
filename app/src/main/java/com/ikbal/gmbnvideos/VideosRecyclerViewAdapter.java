package com.ikbal.gmbnvideos;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ikbal.gmbnvideos.api.YoutubeVideo;
import com.squareup.picasso.Picasso;

import java.util.List;

class VideosRecyclerViewAdapter extends RecyclerView.Adapter<VideosRecyclerViewAdapter.VideoViewHolder> {
    private final List<YoutubeVideo> videos;

    public VideosRecyclerViewAdapter(List<YoutubeVideo> videos) {
        this.videos = videos;
    }

    interface OnItemClickListener {
        void onVideoItemClick(YoutubeVideo video);
    }

    private OnItemClickListener onItemClickListener;


    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_video, viewGroup, false);

        VideoViewHolder videoViewHolder = new VideoViewHolder(itemView);
        return videoViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder videoViewHolder, int i) {
        final YoutubeVideo video = videos.get(i);
        videoViewHolder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) onItemClickListener.onVideoItemClick(video);
        });

        videoViewHolder.videoTitleTextView.setText(video.getSnippet().getTitle());
        Picasso.get().load(video.getSnippet().getThumbnails().getDefaultThumbnail().getUrl())
                .placeholder(R.drawable.video_placeholder)
                .into(videoViewHolder.videoImageView);

    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView videoImageView;
        TextView videoTitleTextView;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            videoImageView = itemView.findViewById(R.id.videoImageView);
            videoTitleTextView = itemView.findViewById(R.id.videoTitleView);
        }
    }
}
