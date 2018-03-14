package com.example.mytvapplication;

import android.annotation.SuppressLint;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v17.leanback.app.VerticalGridFragment;
import android.support.v17.leanback.widget.ArrayObjectAdapter;
import android.support.v17.leanback.widget.VerticalGridPresenter;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 3NET01 on 14/03/2018.
 */

@SuppressLint("ValidFragment")
class MyVerticalGridFragment extends VerticalGridFragment{
    private static final String TAG = MyVerticalGridFragment.class.getSimpleName();
    private static final int NUM_COLUMNS = 4;
    private ArrayObjectAdapter mAdapter;
    private LinkedHashMap<String, List<Movie>> mVideoLists = null;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setTitle("My Beautifull Title");
        setupFragment();
    }

    private void setupFragment() {
        VerticalGridPresenter gridPresenter = new VerticalGridPresenter();
        gridPresenter.setNumberOfColumns(NUM_COLUMNS);
        setGridPresenter(gridPresenter);

        mAdapter = new ArrayObjectAdapter(new CardPresenter());

        try {
            load();

        } catch (Exception e) {
            Log.e(TAG, e.toString());
        }
        setAdapter(mAdapter);
    }

    private void load() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TheRandomUserAPI service = retrofit.create(TheRandomUserAPI.class);
        Call<RandomUser> repos = service.listUsers(15);
        repos.enqueue(new Callback<RandomUser>() {
            @Override
            public void onResponse(Call<RandomUser> call, Response<RandomUser> response) {
                List<RandomUser.Result> users = response.body().getResults();
                for (int j = 0; j < users.size(); j++) {
                    RandomUser.Result user = users.get(j);
                    mAdapter.add(user);
                }
            }

            @Override
            public void onFailure(Call<RandomUser> call, Throwable t) {
                Log.e(TAG, t.toString());
                load();
            }
        });
    }
}
