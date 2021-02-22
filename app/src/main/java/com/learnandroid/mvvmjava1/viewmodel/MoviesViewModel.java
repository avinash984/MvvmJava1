package com.learnandroid.mvvmjava1.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.learnandroid.mvvmjava1.api.ApiClient;
import com.learnandroid.mvvmjava1.api.ApiInterface;
import com.learnandroid.mvvmjava1.model.Hero;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously
    private MutableLiveData<List<Hero>> heroList;
    //we will call this method to get the data
    public LiveData<List<Hero>> getHeroes() {
        //if the list is null
        if (heroList == null) {
            heroList = new MutableLiveData<List<Hero>>();
            //we will load it asynchronously from server in this method
            getMoviesData();
        }

        //finally we will return the list
        return heroList;
    }
    private void getMoviesData(){

        ApiInterface apIinterface = ApiClient.getRetrofitClientForAuth().create(ApiInterface.class);
        Call<List<Hero>> ResultCall = apIinterface.getHeroes();
        ResultCall.enqueue(new Callback<List<Hero>>() {
            @Override
            public void onResponse(Call<List<Hero>> call, Response<List<Hero>> response) {
                //finally we are setting the list to our MutableLiveData
                heroList.setValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Hero>> call, Throwable t) {

            }
        });
    }
}
