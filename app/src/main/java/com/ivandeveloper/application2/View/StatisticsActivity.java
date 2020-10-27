package com.ivandeveloper.application2.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Toast;

import com.ivandeveloper.application2.Adapter.StatisticsAdapter;
import com.ivandeveloper.application2.Adapter.TeamsAdapter;
import com.ivandeveloper.application2.Controller.MinorController;
import com.ivandeveloper.application2.Model.CountryModel;
import com.ivandeveloper.application2.Model.GameWinLoseModel;
import com.ivandeveloper.application2.Model.PointsModel;
import com.ivandeveloper.application2.Model.TeamStatisticsModel;
import com.ivandeveloper.application2.Model.TeamStatisticsModelResponse;
import com.ivandeveloper.application2.Model.TeamsModel;
import com.ivandeveloper.application2.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class StatisticsActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    StatisticsAdapter adapter;
    MinorController minorController;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);
        minorController = new MinorController();
        getSupportActionBar().setTitle("Team Statistics");
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        recyclerView = findViewById(R.id.statistics_recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        String passedArg = getIntent().getExtras().getString("data");
        getStats(passedArg);
    }

    public void getStats(String id){
        Call<TeamStatisticsModel> call = minorController.RetrofitBuilder().getStatistics(1,getYear(),id);

        call.enqueue(new Callback<TeamStatisticsModel>() {
            @Override
            public void onResponse(Call<TeamStatisticsModel> call, retrofit2.Response<TeamStatisticsModel> response) {

                TeamStatisticsModel teamsModelList = response.body();
                TeamStatisticsModelResponse responseList = teamsModelList.getResponse();
                TeamStatisticsModelResponse teamStats = new TeamStatisticsModelResponse(
                        responseList.getCountry(),
                        responseList.getLeague(),
                        responseList.getTeam(),
                        responseList.getGames(),
                        responseList.getPoints());

//                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa "+teams);

                adapter = new StatisticsAdapter(StatisticsActivity.this, teamStats, StatisticsActivity.this);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<TeamStatisticsModel> call, Throwable t) {
                Toast.makeText(StatisticsActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa " + t.getMessage());
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