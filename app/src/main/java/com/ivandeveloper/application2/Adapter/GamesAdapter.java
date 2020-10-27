package com.ivandeveloper.application2.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.ivandeveloper.application2.Controller.MinorController;
import com.ivandeveloper.application2.Model.GameModelResponse;
import com.ivandeveloper.application2.R;
import com.ivandeveloper.application2.View.FullGameDetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class GamesAdapter extends RecyclerView.Adapter<GamesAdapter.GamesViewHolder> {

    List<GameModelResponse> gameIDList;
    GameModelResponse gameID;
    public static class GamesViewHolder extends RecyclerView.ViewHolder {
        public TextView teamHome;
        public TextView teamAway;
        public ImageView picHome;
        public ImageView picAway;
        public TextView scoreHome;
        public TextView scoreAway;
        public TextView winLose;
        public TextView gameId;
        public GamesViewHolder(@NonNull View itemView) {
            super(itemView);
            gameId = itemView.findViewById(R.id.full_game_id);
            teamHome = itemView.findViewById(R.id.team_one);
            teamAway = itemView.findViewById(R.id.team_two);
            scoreHome = itemView.findViewById(R.id.score_home);
            winLose = itemView.findViewById(R.id.win_lose);
            scoreAway = itemView.findViewById(R.id.score_away);
            picHome = itemView.findViewById(R.id.team_one_image);
            picAway = itemView.findViewById(R.id.team_two_image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    MinorController minorController = new MinorController();
                    minorController.NextIntent(v.getContext(), FullGameDetailsActivity.class, gameId.getText().toString());
                }
            });
        }
    }

    public GamesAdapter(Context context, List<GameModelResponse> gameIDList) {
        this.gameIDList = gameIDList;
    }

    @NonNull
    @Override
    public GamesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_list,parent,false);
        return new GamesViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull GamesViewHolder holder, int position) {
        gameID = gameIDList.get(position);
        holder.gameId.setText(gameID.getId().toString());
        holder.teamHome.setText(gameID.getTeams().getHome().getName());
        holder.teamAway.setText(gameID.getTeams().getAway().getName());
        holder.scoreHome.setText(Integer.toString(gameID.getScores().getHome().getTotal()));
        holder.scoreAway.setText(Integer.toString(gameID.getScores().getAway().getTotal()));
        Picasso.get().load(gameID.getTeams().getHome().getLogo()).into(holder.picHome);
        Picasso.get().load(gameID.getTeams().getAway().getLogo()).into(holder.picAway);

        if(gameID.getScores().getHome().getTotal() > gameID.getScores().getAway().getTotal()){
            holder.winLose.setText("W - L");
        }else{
            holder.winLose.setText("L - W");
        }
    }

    @Override
    public int getItemCount() {
        return gameIDList.size();
    }
}
