package com.fxc.myvideoplayer;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.Constraints;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.List;


public class FolderAdapter extends RecyclerView.Adapter<FolderAdapter.ViewHolder> {
    Context context;
    List<FolderItems> folders;

    public FolderAdapter(Context context, List<FolderItems> folders) {
        this.context = context;
        this.folders = folders;
    }


    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.folder_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
     final FolderItems folder = folders.get(position);
        Glide.with(context)
                .load(folder.get_image_Resource())
                .into(holder.img);
        holder.folder_name.setText(folder.get_folder_cat_name());
        holder.folder_num.setText(folder.get_folder_number());
        holder.folder_item.setOnClickListener(new View.OnClickListener() {
    @Override
        public void onClick(View v) {
       //启动file list activity
        startFileListActivity(folder);
    }
});

    }
    private void startFileListActivity(FolderItems folder){
        Intent intent = new Intent(context,FileListActivity.class);
        intent.putExtra("folder_cat_name",folder.get_folder_cat_name());
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return folders.size();
    }
   //内部类
    class ViewHolder extends RecyclerView.ViewHolder{
       ConstraintLayout folder_item;
       TextView folder_name;
       TextView folder_num;
       ImageView img;

        public ViewHolder(View itemView) {
            super(itemView);
            folder_item = itemView.findViewById(R.id.folder_item);
            folder_name = itemView.findViewById(R.id.folder_cat_name);
            folder_num = itemView.findViewById(R.id.folder_numbers);
            img = itemView.findViewById(R.id.folder_image);
        }


    }
}
