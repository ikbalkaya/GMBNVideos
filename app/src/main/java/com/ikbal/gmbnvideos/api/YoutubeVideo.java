package com.ikbal.gmbnvideos.api;

import com.google.gson.annotations.SerializedName;
/**
A light version of video object * */
public class YoutubeVideo {
    private int id;

    class Id{
        private String videoId;

        public String getVideoId() {
            return videoId;
        }
    }
    class Snippet{
        private String title;

        public String getTitle() {
            return title;
        }
    }
    class Thumbnails{
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
    class Thumbnail{
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
