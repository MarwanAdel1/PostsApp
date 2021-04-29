package com.example.fullapp.ui.main;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fullapp.R;
import com.example.fullapp.pojo.PostsModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {
    private List<PostsModel> postsList = new ArrayList<PostsModel>();


    @NonNull
    @Override
    public PostAdapter.PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.post_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.idTV.setText(postsList.get(position).getUserId()+"");
        holder.titleTV.setText(postsList.get(position).getTitle());
        holder.bodyTV.setText(postsList.get(position).getBody());
    }


    @Override
    public int getItemCount() {
        return postsList.size();
    }

    public class PostViewHolder extends RecyclerView.ViewHolder {
        TextView idTV, titleTV, bodyTV;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            idTV = itemView.findViewById(R.id.id_TV);
            titleTV = itemView.findViewById(R.id.title_TV);
            bodyTV = itemView.findViewById(R.id.body_TV);
        }
    }


    public void setPostsList(List<PostsModel> postsList)  {
        this.postsList=postsList;
        notifyDataSetChanged();
    }
}
