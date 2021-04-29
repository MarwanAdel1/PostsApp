package com.example.fullapp.data;

import com.example.fullapp.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClients {
    private static final String BASE_URL="https://jsonplaceholder.typicode.com/";
    private PostsInterface mPostsInterface;
    private static PostsClients INSTANCE;

    public PostsClients() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mPostsInterface = retrofit.create(PostsInterface.class);
    }

    public static PostsClients getInstance(){
        if (INSTANCE == null){
            INSTANCE = new PostsClients();
        }
        return INSTANCE;
    }

    public Call<List<PostsModel>> getPosts(){
        Call<List<PostsModel>> call = mPostsInterface.getPosts();
        return call;
    }
}
