package com.ivandeveloper.application2.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.ivandeveloper.application2.Controller.Connection;
import com.ivandeveloper.application2.Controller.MinorController;
import com.ivandeveloper.application2.R;
import com.ivandeveloper.application2.View.Fragment.PlayerFragment;
import com.ivandeveloper.application2.View.Fragment.NewsFragment;
import com.ivandeveloper.application2.View.Fragment.SeasonFragment;
import com.ivandeveloper.application2.View.Fragment.TeamFragment;

public class Listings extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listings);
        connection = new Connection();



        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Third Base");
        navigationView.setNavigationItemSelectedListener(this);

        actionBarDrawerToggle = new ActionBarDrawerToggle( this, drawerLayout,toolbar,(R.string.Open),(R.string.Close));
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true);
        actionBarDrawerToggle.syncState();

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.frame_layout, new NewsFragment());
        fragmentTransaction.commit();

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        if (connection.isConnected(Listings.this)) {
            if (item.getItemId() == R.id.home_button) {
                getSupportActionBar().setTitle("MLB Updates");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new NewsFragment());
                fragmentTransaction.commit();
            }
            if (item.getItemId() == R.id.teams_button) {
                getSupportActionBar().setTitle("Teams");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new TeamFragment());
                fragmentTransaction.commit();
            }
            if (item.getItemId() == R.id.games_button) {
                Intent intent = new Intent(Listings.this, GameActivity.class);
                startActivity(intent);
            }
            if (item.getItemId() == R.id.player_button) {
                getSupportActionBar().setTitle("Third Base");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_layout, new PlayerFragment());
                fragmentTransaction.commit();
            }
        }
        return true;
    }


}