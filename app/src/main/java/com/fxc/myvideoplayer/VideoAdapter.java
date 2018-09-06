package com.fxc.myvideoplayer;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ViewHolder> {
    Context context;
    List<VideoItems> videos;

    public VideoAdapter(Context context, List<VideoItems> videos) {
        this.context = context;
        this.videos = videos;
    }
    @Override
    public VideoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.file_item, parent, false);
        Log.i("onCreate","28");
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final VideoItems video = videos.get(position);
        Glide.with(context)
                .load(video.get_image_Resource())
                .into(holder.video_image);
        holder.video_name.setText(video.get_video_name());
        holder.video_duration.setText(video.get_video_duration());
        Log.i("onBind","39");
        holder.file_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
                //启动播放activity
            }
        });
    }

    @Override
    public int getItemCount() {
        Log.i("getItemCount","53");
        return videos.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ConstraintLayout file_item;
        TextView video_name;
        TextView video_duration;
        ImageView video_image;

        public ViewHolder(View itemView) {
            super(itemView);
            file_item = itemView.findViewById(R.id.file_item);
            video_name = itemView.findViewById(R.id.video_name);
            video_duration = itemView.findViewById(R.id.video_duration);
            Log.i("view holder","66");
            video_image = itemView.findViewById(R.id.video_image);

        }
    }
    }

