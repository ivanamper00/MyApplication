package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class LeagueModel {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("type")
    private String type;
    @SerializedName("logo")
    private String logo;
    @SerializedName("season")
    private Integer season;

    public LeagueModel(int id, String name, String type, String logo, Integer season) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.logo = logo;
        this.season = season;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getLogo() {
        return logo;
    }

    public Integer getSeason() {
        return season;
    }
}
