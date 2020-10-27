package com.ivandeveloper.application2.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.ivandeveloper.application2.Adapter.FullGameAdapter;
import com.ivandeveloper.application2.Adapter.GamesAdapter;
import com.ivandeveloper.application2.Controller.MinorController;
import com.ivandeveloper.application2.Model.GameModelResponse;
import com.ivandeveloper.application2.Model.GamesModel;
import com.ivandeveloper.application2.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class FullGameDetailsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    MinorController minorController;
    GridLayoutManager grid;
    FullGameAdapter adapter;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_game_details);
        String passedArg = getIntent().getExtras().getString("data");
        minorController = new MinorController();
        getSupportActionBar().setTitle("Game Details");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.full_game_recycler);
        grid = new GridLayoutManager(this, 1, GridLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(grid);
        getGames(passedArg);
    }

    private void getGames(String id) {

        Call<GamesModel> call = minorController.RetrofitBuilder().getGamesbyId(id);

        call.enqueue(new Callback<GamesModel>() {
            @Override
            public void onResponse(Call<GamesModel> call, retrofit2.Response<GamesModel> response) {

                GamesModel gameList = response.body();
                List<GameModelResponse> responseList = gameList.getResponse();
                List<GameModelResponse> gamesList = new ArrayList<>();

                for (int i = 0; i < responseList.size(); i++) {
                    gamesList.add(new GameModelResponse(
                            responseList.get(i).getId(),
                            responseList.get(i).getTeams(),
                            responseList.get(i).getScores()));
                }
//                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa "+teams);

                adapter = new FullGameAdapter(FullGameDetailsActivity.this, gamesList);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<GamesModel> call, Throwable t) {
                Toast.makeText(FullGameDetailsActivity.this , t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public String getYear(){
        Calendar calendar;
        SimpleDateFormat simpleDateFormat;
        String date;
        calendar = Calendar.getInstance();
        simpleDateFormat = new SimpleDateFormat("yyyy");
        date = simpleDateFormat.format(calendar.getTime());
        return date;
    }

}