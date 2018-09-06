package com.fxc.myvideoplayer.VideoList;

public class VideoItems {
    private String video_name;
    private String video_duration;
    private int image_Resource;

    public VideoItems(int image_Resource, String video_name, String video_duration) {
        this.image_Resource = image_Resource;
        this.video_name = video_name;
        this.video_duration = video_duration;
    }
    public int get_image_Resource() { return image_Resource; }
    public String get_video_name() { return video_name; }
    public String get_video_duration() { return video_duration; }

}
