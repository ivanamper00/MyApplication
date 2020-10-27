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

import com.ivandeveloper.application2.Model.PlayersModel;
import com.ivandeveloper.application2.R;
import com.squareup.picasso.Picasso;

public class PlayerDetailsAdapter extends RecyclerView.Adapter<PlayerDetailsAdapter.PlayersViewHolder>{

        PlayersModel players;
        public static class PlayersViewHolder extends RecyclerView.ViewHolder{
            TextView playerName;
            TextView playerTeam;
            TextView playerPosition;
            TextView batHand;
            TextView throwHand;
            TextView weight;
            TextView height;
            TextView proDebut;
            TextView experience;
            TextView jerseyNumber;
            ImageView playerImage;
            public PlayersViewHolder(@NonNull View itemView) {
                super(itemView);
                playerName = itemView.findViewById(R.id.player_name);
                jerseyNumber = itemView.findViewById(R.id.player_number);
                playerTeam = itemView.findViewById(R.id.player_team);
                playerPosition = itemView.findViewById(R.id.player_position);
                batHand = itemView.findViewById(R.id.player_bat_hand);
                throwHand = itemView.findViewById(R.id.player_throw_hand);
                weight = itemView.findViewById(R.id.player_weight);
                height = itemView.findViewById(R.id.player_height);
                proDebut = itemView.findViewById(R.id.player_debut);
                experience = itemView.findViewById(R.id.player_experience);
                playerImage = itemView.findViewById(R.id.player_detail_picture);
            }
        }

        public PlayerDetailsAdapter(Context context, PlayersModel playerList) {
            this.players = playerList;
        }

        @NonNull
        @Override
        public PlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.player_details_list,parent,false);
            return new PlayersViewHolder(view);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onBindViewHolder(@NonNull PlayersViewHolder holder, int position) {
            Picasso.get().load(players.getPhotoUrl()).into(holder.playerImage);
            holder.jerseyNumber.setText( players.getJersey());
            holder.playerName.setText( players.getFirstName() + " " + players.getLastName());
            holder.playerTeam.setText( players.getTeam());
            holder.playerPosition.setText( players.getPosition());
            holder.batHand.setText( players.getBatHand());
            holder.throwHand.setText( players.getThrowHand());
            holder.weight.setText( players.getWeight());
            holder.height.setText( players.getHeight());
            holder.proDebut.setText( players.getProDebut());
            holder.experience.setText( players.getExperience());
        }

        @Override
        public int getItemCount() {
            return 1;
        }
    }

