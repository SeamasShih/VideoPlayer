package com.fxc.myvideoplayer;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ImageView;

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


        List<VideoItems> videos = VideoFactory.create_videos(10);
        VideoAdapter adapter = new VideoAdapter(this,videos);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.rv_video);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        Log.i("Main","35");
        recyclerView.addItemDecoration(new FolderItemDecoration(2));


    }

}
