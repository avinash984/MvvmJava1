package com.learnandroid.mvvmjava1.api;

import com.learnandroid.mvvmjava1.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("marvel")
    Call<List<Hero>> getHeroes();
}
