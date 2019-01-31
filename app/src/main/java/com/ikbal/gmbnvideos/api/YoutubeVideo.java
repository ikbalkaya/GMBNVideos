package com.ikbal.gmbnvideos.api;

import com.google.gson.annotations.SerializedName;


/**
A light version of video object * */
public class YoutubeVideo {
    private Id id;

    private String videoId;
    private Snippet snippet;
    private ContentDetails contentDetails;
    private String publishedAt;
    private String description;

    public Id getId() {
        return id;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public ContentDetails getContentDetails() {
        return contentDetails;
    }

    public Snippet getSnippet() {
        return snippet;
    }


    public class Id{
        private String videoId;

        public String getVideoId() {
            return videoId;
        }
    }
    public class Snippet{
        private String title;
        private Thumbnails thumbnails;

        public String getTitle() {
            return title;
        }

        public Thumbnails getThumbnails() {
            return thumbnails;
        }
    }
    public class ContentDetails{
        private String duration;

        public String getDuration() {
            return duration;
        }
    }
    public class Thumbnails{
        @SerializedName("default")
        private Thumbnail defaultThumbnail;
        private Thumbnail medium;
        private Thumbnail high;

        public Thumbnail getDefaultThumbnail() {
            return defaultThumbnail;
        }

        public Thumbnail getMedium() {
            return medium;
        }

        public Thumbnail getHigh() {
            return high;
        }
    }
    public class Thumbnail{
        private String url;
        private int width;
        private int height;

        public String getUrl() {
            return url;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }
    }

}
