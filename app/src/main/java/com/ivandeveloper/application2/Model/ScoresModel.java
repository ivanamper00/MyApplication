package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class ScoresModel {
    @SerializedName("home")
    private HomeAwayScoreModel home;
    @SerializedName("away")
    private HomeAwayScoreModel away;

    public HomeAwayScoreModel getHome() {
        return home;
    }

    public void setHome(HomeAwayScoreModel home) {
        this.home = home;
    }

    public HomeAwayScoreModel getAway() {
        return away;
    }

    public void setAway(HomeAwayScoreModel away) {
        this.away = away;
    }
}
