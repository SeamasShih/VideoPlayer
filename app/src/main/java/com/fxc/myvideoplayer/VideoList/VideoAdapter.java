package com.fxc.myvideoplayer.VideoList;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.ThumbnailUtils;
import android.provider.MediaStore;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fxc.myvideoplayer.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    Context context;
    List<VideoItems> videos;

    public VideoAdapter(Context context, List<VideoItems> videos) {
        this.context = context;
        this.videos = videos;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        //list显示

        //View itemView = inflater.inflate(R.layout.file_item, parent, false);
        //Grid 显示
        View itemView = inflater.inflate(R.layout.video_item_grid, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
    VideoItems videoItem = videos.get(position);


    /*Glide.with(context)
            .load(videoItem.get_image_Resource())
            .into(holder.video_image);*/
    holder.video_name.setText(videoItem.get_video_name());

        SimpleDateFormat sdf = new SimpleDateFormat("mm:ss");
        String time = sdf.format(new Date(videoItem.get_video_duration()));
        holder.video_duration.setText(time);
        //      获取视频缩略图，显示缩略图
        Bitmap thumbnail = ThumbnailUtils.createVideoThumbnail
                (videoItem.get_video_path(), MediaStore.Video.Thumbnails.MINI_KIND);
        holder.video_image.setImageBitmap(thumbnail);
    }
    @Override
    public int getItemCount() {
        return videos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ConstraintLayout file_item;
        TextView video_name;
        TextView video_duration;
        ImageView video_image;

        public ViewHolder(View itemView) {
            super(itemView);
            file_item = itemView.findViewById(R.id.file_item);
            video_duration= itemView.findViewById(R.id.video_duration);
            video_name = itemView.findViewById(R.id.video_name);
            video_image = itemView.findViewById(R.id.video_image);
        }
    }
}


