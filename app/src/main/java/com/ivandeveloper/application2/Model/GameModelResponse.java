package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class GameModelResponse {
    @SerializedName("id")
    private Integer id;
    @SerializedName("date")
    private String date;
    @SerializedName("time")
    private String time;
    @SerializedName("timestamp")
    private Integer timestamp;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("week")
    private Object week;
    @SerializedName("status")
    private StatusModel status;
    @SerializedName("country")
    private CountryModel country;
    @SerializedName("league")
    private LeagueModel league;
    @SerializedName("teams")
    private HomeAwayTeamModel teams;
    @SerializedName("scores")
    private ScoresModel scores;

        public GameModelResponse(Integer id, String date, String time, Integer timestamp, String timezone, Object week, StatusModel status, CountryModel country, LeagueModel league, HomeAwayTeamModel teams, ScoresModel scores) {
            this.id = id;
            this.date = date;
            this.time = time;
            this.timestamp = timestamp;
            this.timezone = timezone;
            this.week = week;
            this.status = status;
            this.country = country;
            this.league = league;
            this.teams = teams;
            this.scores = scores;
        }

    public GameModelResponse(Integer id, HomeAwayTeamModel teams, ScoresModel scores) {
        this.id = id;
        this.teams = teams;
        this.scores = scores;
    }

    public Integer getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public Integer getTimestamp() {
        return timestamp;
    }

    public String getTimezone() {
        return timezone;
    }

    public Object getWeek() {
        return week;
    }

    public StatusModel getStatus() {
        return status;
    }

    public CountryModel getCountry() {
        return country;
    }

    public LeagueModel getLeague() {
        return league;
    }

    public HomeAwayTeamModel getTeams() {
        return teams;
    }

    public ScoresModel getScores() {
        return scores;
    }
}
