package com.ivandeveloper.application2.View;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.ivandeveloper.application2.Controller.MinorController;
import com.ivandeveloper.application2.R;
import com.ivandeveloper.application2.View.Fragment.PlayerFragment;
import com.ivandeveloper.application2.View.Fragment.SeasonFragment;
import com.ivandeveloper.application2.View.Fragment.TeamFragment;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {
    MinorController minorController;
    RecyclerView recyclerViewTeams;
    RecyclerView recyclerViewGames;
    GridLayoutManager grid;
//    ImageView games;
//    ImageView teams;
//    ImageView league;
//    ImageView mitt;
//    ImageView settings;

    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;

//    GamesFragment gamesFragment;
    PlayerFragment playerFragment;
    SeasonFragment seasonFragment;
    TeamFragment teamFragment;


//    List<GameIDModel.Response> gamesList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();

        viewPager = findViewById(R.id.view_pager);
        tabLayout = findViewById(R.id.tab_layout);

//        gamesFragment = new GamesFragment();
//        teamFragment = new TeamFragment();
        playerFragment = new PlayerFragment();
        seasonFragment = new SeasonFragment();

        tabLayout.setupWithViewPager(viewPager);

        ViewPageAdapter viewPageAdapter = new ViewPageAdapter(getSupportFragmentManager(),0);
//        viewPageAdapter.addFragment(gamesFragment);
        viewPageAdapter.addFragment(teamFragment);
        viewPageAdapter.addFragment(playerFragment);
        viewPageAdapter.addFragment(seasonFragment);
        viewPager.setAdapter(viewPageAdapter);
        tabLayout.getTabAt(0).setIcon(R.drawable.scoreboard);
        tabLayout.getTabAt(1).setIcon(R.drawable.baseball);
        tabLayout.getTabAt(2).setIcon(R.drawable.baseball_hat);
        tabLayout.getTabAt(3).setIcon(R.drawable.baseball_mitt);




        recyclerViewTeams = findViewById(R.id.teams_list);
        grid = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false);
        recyclerViewTeams.setLayoutManager(grid);
////        games = findViewById(R.id.games);
//////        games.setTooltipText("Games");
////        teams = findViewById(R.id.teams);
//////        teams.setTooltipText("Teams");
////        league = findViewById(R.id.league);
//////        league.setTooltipText("League");
////        mitt = findViewById(R.id.mitt);
//////        mitt.setTooltipText("Coming Soon");
////        settings = findViewById(R.id.settings);
//////        settings.setTooltipText("Settings");
////
//        minorController = new MinorController();
//
//
////        getGames();
//        if(gamesList.size() != 0){
//            GamesAdapter adapter = new GamesAdapter(Dashboard.this, gamesList);
//            recyclerViewGames.setAdapter(adapter);
//        }else{
//            recyclerViewGames.inflate(Dashboard.this,R.layout.no_result_games,recyclerViewGames);
////            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_list,parent,false);
//        }
//
//
//        System.out.println(gamesList);
////        getTeamsData(2020);
////        System.out.println(minorController.getYear());
//

    }

    private class ViewPageAdapter extends FragmentPagerAdapter{

        private List<Fragment> fragments = new ArrayList<>();
//        private List<String> fragmentTitle = new ArrayList<>();

        public ViewPageAdapter(@NonNull FragmentManager fm, int behavior) {
            super(fm, behavior);
        }

        public void addFragment(Fragment fragment){
            fragments.add(fragment);
//            fragmentTitle.add(title);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return fragmentTitle.get(position);
//        }


    }



//    private void getTeamsData(int l,int s) {
//
//
//        Call<TeamsModel> call = minorController.RetrofitBuilder().getTeams(l,s);
//
//        call.enqueue(new Callback<TeamsModel>() {
//            @Override
//            public void onResponse(Call<TeamsModel> call, retrofit2.Response<TeamsModel> response) {
//
//                TeamsModel teamsModelList = response.body();
//                List<TeamsModel.Response> responseList = teamsModelList.getResponse();
//                List<TeamsModel.Response> teams = new ArrayList<>();
//
//                    for (int i = 0; i < responseList.size(); i++) {
//                        teams.add(new TeamsModel.Response(responseList.get(i).getId(),
//                                responseList.get(i).getName(),
//                                responseList.get(i).getLogo(),
//                                responseList.get(i).getCountry()));
//                    }
////                System.out.println(teams);
//
//                TeamsAdapter adapter = new TeamsAdapter(Dashboard.this, teams);
//                recyclerViewTeams.setAdapter(adapter);
//            }
//
//            @Override
//            public void onFailure(Call<TeamsModel> call, Throwable t) {
//                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }
//    public void getTeamsData(int s){
//        getTeamsData(1,s);
//    }

//    private void getGames() {
//        minorController = new MinorController();
//
//        for(int i=1 ; ; i++){
//            try {
//                Call<GameIDModel> call = minorController.RetrofitBuilder().getGames(i);
//                call.enqueue(new Callback<GameIDModel>() {
//                    @Override
//                    public void onResponse(Call<GameIDModel> call, retrofit2.Response<GameIDModel> response) {
//                        GameIDModel gameIDModelList = response.body();
//                        GameIDModel.Response responseList = gameIDModelList.getResponse();
//
//                        gamesList.add(new GameIDModel.Response(responseList.getId(),
//                                responseList.getDate(),
//                                responseList.getTime(),
//                                responseList.getTimestamp(),
//                                responseList.getTimezone(),
//                                responseList.getWeek(),
//                                responseList.getStatus(),
//                                responseList.getCountry(),
//                                responseList.getLeague(),
//                                responseList.getTeams(),
//                                responseList.getScores()
//
//                        ));
//                    }
//
//                    @Override
//                    public void onFailure(Call<GameIDModel> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                });
//            }
//            catch (Exception e){
//                break;
//            }
//        }
//
//    }





}


//

//
