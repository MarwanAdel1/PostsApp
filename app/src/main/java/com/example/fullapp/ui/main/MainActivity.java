package com.example.fullapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.fullapp.R;
import com.example.fullapp.pojo.PostsModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    PostsViewModel mPostsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPostsViewModel = ViewModelProviders.of(this).get(PostsViewModel.class);
        mPostsViewModel.getPost();

        RecyclerView recyclerView= findViewById(R.id.recycler_view);
        PostAdapter postAdapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(postAdapter);

        mPostsViewModel.mPostsMutableLiveData.observe(this, new Observer<List<PostsModel>>() {
            @Override
            public void onChanged(List<PostsModel> postsModels) {
                postAdapter.setPostsList(postsModels);
            }
        });
    }
}