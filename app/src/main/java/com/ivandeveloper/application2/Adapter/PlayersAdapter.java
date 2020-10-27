package com.ivandeveloper.application2.Adapter;

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
import com.ivandeveloper.application2.Model.PlayersModel;
import com.ivandeveloper.application2.R;
import com.ivandeveloper.application2.View.PlayerDetailsActivty;
import com.ivandeveloper.application2.View.StatisticsActivity;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

public class PlayersAdapter extends RecyclerView.Adapter<PlayersAdapter.PlayersViewHolder> {
    public static List<PlayersModel> playerList;
    PlayersModel players;

    public static class PlayersViewHolder extends RecyclerView.ViewHolder{
        TextView playerLastName;
        TextView jerseyNumber;
        ImageView playerImage;
        public PlayersViewHolder(@NonNull View itemView) {
            super(itemView);
//            playerLastName = itemView.findViewById(R.id.player_last_name);
//            jerseyNumber = itemView.findViewById(R.id.player_jersey_num);
//            playerImage = itemView.findViewById(R.id.player_picture);

            itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    MinorController minorController = new MinorController();
                    for(int i=0 ; i < playerList.size() ; i++){
                        if((playerLastName.getText() == playerList.get(i).getLastName()) && (jerseyNumber.getText() == playerList.get(i).getJersey())){
                            String id = playerList.get(i).getPlayerID();
                            minorController.NextIntent(v.getContext(), PlayerDetailsActivty.class, id);
                            break;
                        }
                    }
                }
            });

        }


    }

    public PlayersAdapter(Context context, List<PlayersModel> playerList) {
        this.playerList = playerList;
    }

    @NonNull
    @Override
    public PlayersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.players_list,parent,false);
        return new PlayersAdapter.PlayersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayersViewHolder holder, int position) {
        players = playerList.get(position);
        Picasso.get().load(players.getPhotoUrl()).into(holder.playerImage);
        holder.jerseyNumber.setText(players.getJersey());
        holder.playerLastName.setText(players.getLastName());
    }

    @Override
    public int getItemCount() {
        return playerList.size();
    }
}
