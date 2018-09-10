package com.fxc.myvideoplayer.VideoList;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


import com.fxc.myvideoplayer.FolderList.FolderItemDecoration;
import com.fxc.myvideoplayer.R;

import java.util.List;

public class FileListActivity extends AppCompatActivity {
    ActionBar actionBar;
    RecyclerView videoRecyclerView;
    RecyclerView.LayoutManager layoutManager;
    VideoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_list);

        actionBar = getSupportActionBar();
        String folderName = getIntent().getStringExtra("folder_cat_name");
        actionBar.setTitle(folderName);

        List<VideoItems> videos = VideoFactory.create_videos(20);
        adapter = new VideoAdapter(this,videos);
        //设置为list
        //layoutManager = new LinearLayoutManager(this);
      // 设置为grid显示
        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(
                2, StaggeredGridLayoutManager.VERTICAL
        );
        videoRecyclerView = findViewById(R.id.rv_video);
        videoRecyclerView.setAdapter(adapter);
        videoRecyclerView.setLayoutManager(layoutManager);
        videoRecyclerView.addItemDecoration(new FolderItemDecoration(2));
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.layout_change, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_layout_list) {
            layoutManager = new LinearLayoutManager(
                    this);
            videoRecyclerView.setLayoutManager(layoutManager);
            adapter.notifyDataSetChanged();

            return true;
        } else if (id == R.id.action_layout_grid) {
            layoutManager = new StaggeredGridLayoutManager(
                    2, StaggeredGridLayoutManager.VERTICAL
            );
          videoRecyclerView.setLayoutManager(layoutManager);
          adapter.notifyDataSetChanged();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
