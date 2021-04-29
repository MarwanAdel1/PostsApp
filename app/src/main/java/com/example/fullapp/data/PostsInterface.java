package com.example.fullapp.data;

import com.example.fullapp.pojo.PostsModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PostsInterface {

    @GET("posts")
    public Call<List<PostsModel>> getPosts();

}
