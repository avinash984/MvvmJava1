package com.learnandroid.mvvmjava1.view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.learnandroid.mvvmjava1.R;
import com.learnandroid.mvvmjava1.adapter.MoviesAdapter;
import com.learnandroid.mvvmjava1.model.Hero;
import com.learnandroid.mvvmjava1.viewmodel.MoviesViewModel;

import java.util.List;

public class MoviesActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    MoviesAdapter adapter;

    List<Hero> heroList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        MoviesViewModel model = ViewModelProviders.of(this).get(MoviesViewModel.class);

        model.getHeroes().observe(this, new Observer<List<Hero>>() {
            @Override
            public void onChanged(@Nullable List<Hero> heroList) {
                adapter = new MoviesAdapter(MoviesActivity.this, heroList);
                recyclerView.setAdapter(adapter);
            }
        });
    }
}