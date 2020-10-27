package com.ivandeveloper.application2.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ivandeveloper.application2.Model.GameModelResponse;
import com.ivandeveloper.application2.R;
import com.squareup.picasso.Picasso;

import java.util.List;


public class FullGameAdapter extends RecyclerView.Adapter<FullGameAdapter.FullGameViewHolder> {

        List<GameModelResponse> gameIDList;
        GameModelResponse gameID;
        Context context;
        public static class FullGameViewHolder extends RecyclerView.ViewHolder {
            public ImageView picHome;
            public TextView teamHome;
            public TextView scoreHome;
            public TextView homeHits;
            public TextView homeErrors;
            public TextView homeOne;
            public TextView homeTwo;
            public TextView homeThree;
            public TextView homeFour;
            public TextView homeFive;
            public TextView homeSix;
            public TextView homeSeven;
            public TextView homeEight;
            public TextView homeNine;
            public TextView homeExtra;

            public ImageView picAway;
            public TextView teamAway;
            public TextView awayHits;
            public TextView awayErrors;
            public TextView scoreAway;
            public TextView awayOne;
            public TextView awayTwo;
            public TextView awayThree;
            public TextView awayFour;
            public TextView awayFive;
            public TextView awaySix;
            public TextView awaySeven;
            public TextView awayEight;
            public TextView awayNine;
            public TextView awayExtra;

            public TextView winLose;
            public FullGameViewHolder(@NonNull View itemView) {
                super(itemView);
                picHome = itemView.findViewById(R.id.home_full_logo);
                teamHome = itemView.findViewById(R.id.home_full_name);
                homeHits = itemView.findViewById(R.id.home_hits);
                homeErrors = itemView.findViewById(R.id.home_errors);
                homeOne = itemView.findViewById(R.id.home_one);
                homeTwo = itemView.findViewById(R.id.home_two);
                homeThree = itemView.findViewById(R.id.home_three);
                homeFour = itemView.findViewById(R.id.home_four);
                homeFive = itemView.findViewById(R.id.home_five);
                homeSix = itemView.findViewById(R.id.home_six);
                homeSeven = itemView.findViewById(R.id.home_seven);
                homeEight = itemView.findViewById(R.id.home_eight);
                homeNine = itemView.findViewById(R.id.home_nine);
                homeExtra = itemView.findViewById(R.id.home_extra);
                scoreHome = itemView.findViewById(R.id.home_score);

                picAway = itemView.findViewById(R.id.away_full_logo);
                teamAway = itemView.findViewById(R.id.away_full_name);
                awayHits = itemView.findViewById(R.id.away_hits);
                awayErrors = itemView.findViewById(R.id.away_errors);
                awayOne = itemView.findViewById(R.id.away_one);
                awayTwo = itemView.findViewById(R.id.away_two);
                awayThree = itemView.findViewById(R.id.away_three);
                awayFour = itemView.findViewById(R.id.away_four);
                awayFive = itemView.findViewById(R.id.away_five);
                awaySix = itemView.findViewById(R.id.away_six);
                awaySeven = itemView.findViewById(R.id.away_seven);
                awayEight = itemView.findViewById(R.id.away_eight);
                awayNine = itemView.findViewById(R.id.away_nine);
                awayExtra = itemView.findViewById(R.id.away_extra);
                scoreAway = itemView.findViewById(R.id.away_score);

                winLose = itemView.findViewById(R.id.ful_game_win_lose);



            }
        }

        public FullGameAdapter(Context context, List<GameModelResponse> gameIDList) {
            this.gameIDList = gameIDList;
            this.context = context;
        }

        @NonNull
        @Override
        public FullGameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.full_game_list,parent,false);
            return new FullGameViewHolder(view);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull FullGameViewHolder holder, int position) {
            gameID = gameIDList.get(position);
            System.out.println(gameID.getTeams().getHome().getLogo());
            Picasso.get().load(gameID.getTeams().getHome().getLogo()).into(holder.picHome);
            holder.teamHome.setText(gameID.getTeams().getHome().getName());
            holder.scoreHome.setText(Integer.toString(gameID.getScores().getHome().getTotal()));
            holder.homeHits.setText(Integer.toString(gameID.getScores().getHome().getHits()));
            holder.homeErrors.setText(Integer.toString(gameID.getScores().getHome().getErrors()));
            holder.homeOne.setText(gameID.getScores().getHome().getInnings().get1().toString());
            holder.homeTwo.setText(gameID.getScores().getHome().getInnings().get2());
            holder.homeThree.setText(gameID.getScores().getHome().getInnings().get3());
            holder.homeFour.setText(gameID.getScores().getHome().getInnings().get4());
            holder.homeFive.setText(gameID.getScores().getHome().getInnings().get5());
            holder.homeSix.setText(gameID.getScores().getHome().getInnings().get6());
            holder.homeSeven.setText(gameID.getScores().getHome().getInnings().get7());
            holder.homeEight.setText(gameID.getScores().getHome().getInnings().get8());
            holder.homeNine.setText( gameID.getScores().getHome().getInnings().get9());
            holder.homeExtra.setText((String) gameID.getScores().getHome().getInnings().getExtra());

            Picasso.get().load(gameID.getTeams().getAway().getLogo()).into(holder.picAway);
            holder.teamAway.setText(gameID.getTeams().getAway().getName());
            holder.scoreAway.setText(Integer.toString(gameID.getScores().getAway().getTotal()));
            holder.awayHits.setText(Integer.toString(gameID.getScores().getAway().getHits()));
            holder.awayErrors.setText(Integer.toString(gameID.getScores().getAway().getErrors()));
            holder.awayOne.setText(gameID.getScores().getAway().getInnings().get1());
            holder.awayTwo.setText(gameID.getScores().getAway().getInnings().get2());
            holder.awayThree.setText(gameID.getScores().getAway().getInnings().get3());
            holder.awayFour.setText(gameID.getScores().getAway().getInnings().get4());
            holder.awayFive.setText(gameID.getScores().getAway().getInnings().get5());
            holder.awaySix.setText(gameID.getScores().getAway().getInnings().get6());
            holder.awaySeven.setText(gameID.getScores().getAway().getInnings().get7());
            holder.awayEight.setText(gameID.getScores().getAway().getInnings().get8());
            holder.awayNine.setText( gameID.getScores().getAway().getInnings().get9());
            holder.awayExtra.setText((String) gameID.getScores().getAway().getInnings().getExtra());

            if(gameID.getScores().getHome().getTotal() > gameID.getScores().getAway().getTotal()){
                holder.winLose.setText("W - L");
            }else{
                holder.winLose.setText("L - W");
            }
        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }

