package com.fxc.myvideoplayer;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;


import java.util.List;

public class FileListActivity extends AppCompatActivity {
ActionBar actionBar;
//ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_list);

        actionBar = getSupportActionBar();
        String folderName = getIntent().getStringExtra("folder_cat_name");
        actionBar.setTitle(folderName);
        Log.i("Main","21");
        //iv = findViewById(R.id.video_image);
        //iv.setImageResource(R.drawable.item1);


        List<VideoItems> videos = VideoFactory.create_videos(20);
        Log.i("name", "onCreate: "+videos.get(0).get_video_name());
        Log.i("duration", "onCreate: "+videos.get(0).get_video_duration());
        VideoAdapter adapter = new VideoAdapter(this,videos);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(
                this);
        Log.i("buju","34");
        RecyclerView videoRecyclerView = findViewById(R.id.rv_video);
        Log.i("find","38");
        videoRecyclerView.setAdapter(adapter);
        Log.i("setAdapter","40");
        videoRecyclerView.setLayoutManager(layoutManager);
        Log.i("Main","42");
       // videoRecyclerView.addItemDecoration(new FolderItemDecoration(2));
        Log.i("Main","44");
    }

}
