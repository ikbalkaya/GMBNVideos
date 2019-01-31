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
    interface OnItemClickListener {
        void onItemClick(int position);
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
        final int position = i;
        videoViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) onItemClickListener.onItemClick(position);
            }
        });

        videoViewHolder.videoTitleTextView.setText("Video number " + (i + 1));
        Picasso.get().load("https://img.youtube.com/vi/JOlc0a2eVTo/sddefault.jpg")
                .placeholder(R.drawable.video_placeholder)
                .into(videoViewHolder.videoImageView);

    }

    @Override
    public int getItemCount() {
        return 88;
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
