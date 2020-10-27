package com.ivandeveloper.application2.Adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
import com.ivandeveloper.application2.Model.TeamsModel;
import com.ivandeveloper.application2.R;
import com.ivandeveloper.application2.View.StatisticsActivity;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeamsAdapter extends RecyclerView.Adapter<TeamsAdapter.TeamsViewHolder> {
    public static List<TeamsModel.Response> responseList;
    public static TeamsModel.Response response;
//    public String id;

    public static class TeamsViewHolder extends RecyclerView.ViewHolder{
        public TextView teamName;
        public ImageView teamImage;
        private MinorController minorController = new MinorController();
        Map<String, String> links = new HashMap<String, String>();

        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);
            teamName = itemView.findViewById(R.id.team_name);
            teamImage = itemView.findViewById(R.id.team_image);

//            links.put("Arizona Diamondbacks","https://www.mlb.com/dbacks");
//            links.put("Baltimore Orioles","https://www.mlb.com/orioles");
//            links.put("Boston Red Sox","https://www.mlb.com/redsox");
//            links.put("Atlanta Braves","https://www.mlb.com/braves");
//            links.put("Canada","https://www.baseball.ca/");
//            links.put("Chicago Cubs","https://www.mlb.com/cubss");
//            links.put("Chicago White Sox","https://www.mlb.com/whitesox");
//            links.put("Cincinnati Reds","https://www.mlb.com/reds");
//            links.put("Cleveland Indians","https://www.mlb.com/indians");
//            links.put("Colorado Rockies","https://www.mlb.com/rockies");
//            links.put("Detroit Tigers","https://www.mlb.com/tigers");
//            links.put("Houston Astros","https://www.mlb.com/astros");
//            links.put("Kansas City Royals","https://www.mlb.com/royals");
//            links.put("Los Angeles Angels","https://www.mlb.com/angels");
//            links.put("Los Angeles Dodgers","https://www.mlb.com/dodgers");
//            links.put("Miami Marlins","https://www.mlb.com/marlins");
//            links.put("Milwaukee Brewers","https://www.mlb.com/brewers");
//            links.put("Minnesota Twins","https://www.mlb.com/twins");
//            links.put("New York Mets","https://www.mlb.com/mets");
//            links.put("New York Yankees","https://www.mlb.com/yankees");
////        links.put("Northeastern","https://www.mlb.com/dbacks");
//            links.put("Oakland Athletics","https://www.mlb.com/athletics");
//            links.put("Philadelphia Phillies","https://www.mlb.com/phillies");
//            links.put("Pittsburgh Pirates","https://www.mlb.com/pirates");
//            links.put("San Diego Padres","https://www.mlb.com/padres");
//            links.put("San Francisco Giants","https://www.mlb.com/giants");
//            links.put("Seattle Mariners","https://www.mlb.com/mariners");
////        links.put("Southeastern","https://www.mlb.com/dbacks");
//            links.put("St.Louis Cardinals","https://www.mlb.com/cardinals");
//            links.put("Tampa Bay Rays","https://www.mlb.com/rays");
//            links.put("Texas Rangers","https://www.mlb.com/rangers");
//            links.put("Toronto Blue Jays","https://www.mlb.com/bluejays");
//            links.put("Washington Nationals","https://www.mlb.com/nationals");

            itemView.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
                @Override
                public void onClick(View v) {
                    for(int i=0 ; i < responseList.size() ; i++){
                        if(teamName.getText() == responseList.get(i).getName()){
                            String id = responseList.get(i).getId().toString();
                            minorController.NextIntent(v.getContext(), StatisticsActivity.class, id);
                            break;
                        }
                    }
//                    System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa "+teamName.getText().toString());
//                    id = getId();
                }
            });
        }
    }

    public TeamsAdapter(Context context, List<TeamsModel.Response> responseList) {
        this.responseList = responseList;
    }

    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.teams_list,parent,false);
        return new TeamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsViewHolder holder, int position) {
        response = responseList.get(position);
        if(response.getName() != "Northeastern" || response.getName() != "Southeastern"){
            holder.teamName.setText(response.getName());
            Picasso.get().load(response.getLogo()).into(holder.teamImage);
        }
    }

    @Override
    public int getItemCount() {
        return responseList.size();
    }
}
