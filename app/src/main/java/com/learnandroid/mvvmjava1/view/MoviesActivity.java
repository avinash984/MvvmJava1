package com.learnandroid.mvvmjava1.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.learnandroid.mvvmjava1.R;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
    }
}