package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class HomeAwayTeamModel {
    @SerializedName("home")
    private TeamsModel.Response home;
    @SerializedName("away")
    private TeamsModel.Response away;

    public TeamsModel.Response getHome() {
        return home;
    }

    public void setHome(TeamsModel.Response home) {
        this.home = home;
    }

    public TeamsModel.Response getAway() {
        return away;
    }

    public void setAway(TeamsModel.Response away) {
        this.away = away;
    }
}
