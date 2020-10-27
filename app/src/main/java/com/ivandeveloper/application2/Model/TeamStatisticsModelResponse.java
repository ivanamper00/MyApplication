package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class TeamStatisticsModelResponse {
    @SerializedName("country")
    private CountryModel country;
    @SerializedName("league")
    private LeagueModel league;
    @SerializedName("team")
    private TeamsModel.Response team;
    @SerializedName("games")
    private GameWinLoseModel games;
    @SerializedName("points")
    private PointsModel points;

        public TeamStatisticsModelResponse(CountryModel country, LeagueModel league, TeamsModel.Response team, GameWinLoseModel games, PointsModel points) {
            super();
            this.country = country;
            this.league = league;
            this.team = team;
            this.games = games;
            this.points = points;
        }

    public CountryModel getCountry() {
        return country;
    }

    public LeagueModel getLeague() {
        return league;
    }

    public TeamsModel.Response getTeam() {
        return team;
    }

    public GameWinLoseModel getGames() {
        return games;
    }

    public PointsModel getPoints() {
        return points;
    }
}
