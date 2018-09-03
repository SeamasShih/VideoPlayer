package com.fxc.myvideoplayer;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class FileListActivity extends AppCompatActivity {
ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_list);

        actionBar = getSupportActionBar();

        String folderName = getIntent().getStringExtra("folder_cat_name");
        actionBar.setTitle(folderName);





    }

}
