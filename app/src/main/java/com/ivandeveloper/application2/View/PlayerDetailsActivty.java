package com.ivandeveloper.application2.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.ivandeveloper.application2.Adapter.PlayerDetailsAdapter;
import com.ivandeveloper.application2.Adapter.PlayersAdapter;
import com.ivandeveloper.application2.Controller.MinorController;
import com.ivandeveloper.application2.Model.PlayersModel;
import com.ivandeveloper.application2.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class PlayerDetailsActivty extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    MinorController minorController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_details_activty);
        minorController = new MinorController();
        recyclerView = findViewById(R.id.player_details_recycler);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        String passedArg = getIntent().getExtras().getString("data");

        getPlayersData(passedArg);
    }

    private void getPlayersData(String playerID) {

        Call<PlayersModel> call = minorController.RetrofitBuilder2().getPlayer(playerID);
        call.enqueue(new Callback<PlayersModel>() {
            @Override
            public void onResponse(Call<PlayersModel> call, retrofit2.Response<PlayersModel> response) {

                PlayersModel playerModelList = response.body();
                PlayersModel rowList = playerModelList;

                PlayersModel rows = new PlayersModel(rowList.getPlayerID(),
                        rowList.getSportsDataID(),
                        rowList.getStatus(),
                        rowList.getTeamID(),
                        rowList.getTeam(),
                        rowList.getJersey(),
                        rowList.getPositionCategory(),
                        rowList.getPosition(),
                        rowList.getmLBAMID(),
                        rowList.getFirstName(),
                        rowList.getLastName(),
                        rowList.getBatHand(),
                        rowList.getThrowHand(),
                        rowList.getHeight(),
                        rowList.getWeight(),
                        rowList.getProDebut(),
                        rowList.getPhotoUrl(),
                        rowList.getExperience());

                PlayerDetailsAdapter adapter = new PlayerDetailsAdapter(PlayerDetailsActivty.this, rows);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<PlayersModel> call, Throwable t) {
                Toast.makeText(PlayerDetailsActivty.this, t.getMessage(), Toast.LENGTH_SHORT).show();
//                System.out.println("asssssssssssssssssssssssssssssss sssssssssssssssssssssssssss sssssssssssssssssssss "+ t.getMessage());
            }
        });
    }
}