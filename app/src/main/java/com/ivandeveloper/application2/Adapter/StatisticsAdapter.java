package com.ivandeveloper.application2.Adapter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ahmadrosid.svgloader.SvgLoader;
import com.ivandeveloper.application2.Model.TeamStatisticsModelResponse;
import com.ivandeveloper.application2.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.StatisticsViewHolder>{

    TeamStatisticsModelResponse statResponse;
    Context context;
    Activity activity;
    public static class StatisticsViewHolder extends RecyclerView.ViewHolder {
        ImageView flagImage;
        ImageView teamLogo;
        TextView totalWins;
        TextView totalLose;
        TextView percentage;
        TextView homeWins;
        TextView homeLose;
        TextView teamName;
        TextView homePercentage;

        public StatisticsViewHolder(@NonNull View itemView) {
            super(itemView);
            flagImage = itemView.findViewById(R.id.team_flag);
            teamLogo = itemView.findViewById(R.id.stat_team_logo);
            totalWins = itemView.findViewById(R.id.total_wins);
            teamName = itemView.findViewById(R.id.stat_team_name);
            totalLose = itemView.findViewById(R.id.total_loses);
            percentage = itemView.findViewById(R.id.total_percentage);
            homeWins = itemView.findViewById(R.id.home_wins);
            homeLose = itemView.findViewById(R.id.home_loses);
            homePercentage = itemView.findViewById(R.id.home_percentage);
        }
    }
    public StatisticsAdapter(Context context, TeamStatisticsModelResponse statResponse, Activity activity) {
        this.statResponse = statResponse;
        this.context = context;
        this.activity = activity;
    }

    @NonNull
    @Override
    public StatisticsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.statistics_list,parent,false);
        return new StatisticsAdapter.StatisticsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticsViewHolder holder, int position) {
        holder.totalWins.setText(statResponse.getGames().getWins().getAll().getTotal().toString());
        holder.teamName.setText(statResponse.getTeam().getName());
        holder.totalLose.setText(statResponse.getGames().getLoses().getAll().getTotal().toString());
        holder.percentage.setText(statResponse.getGames().getWins().getAll().getPercentage().toString());
        holder.homeWins.setText(statResponse.getGames().getWins().getHome().getTotal().toString());
        holder.homeLose.setText(statResponse.getGames().getLoses().getHome().getTotal().toString());
        holder.homePercentage.setText(statResponse.getGames().getWins().getHome().getPercentage().toString());
        Picasso.get().load(statResponse.getTeam().getLogo()).into(holder.teamLogo);

        if(statResponse.getCountry().getFlag().contains(".svg")){
            SvgLoader.pluck()
                    .with(activity)
                    .load(Uri.parse(statResponse.getCountry().getFlag()), holder.flagImage);
        }else{
            Picasso.get().load(statResponse.getCountry().getFlag()).into(holder.flagImage);
        }

//        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa "+statResponse.getGames().getWins().getAll().getTotal());

    }

    @Override
    public int getItemCount() {
        return 1;
    }
}
