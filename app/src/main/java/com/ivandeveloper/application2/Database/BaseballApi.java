package com.ivandeveloper.application2.Database;

import com.ivandeveloper.application2.Model.GamesModel;
import com.ivandeveloper.application2.Model.TeamStatisticsModel;
import com.ivandeveloper.application2.Model.TeamsModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface BaseballApi {

    String BASE_URL = "https://api-baseball.p.rapidapi.com/";

    @Headers({"x-rapidapi-host: api-baseball.p.rapidapi.com",
                "x-rapidapi-key: 07e55202eemshd454005e3a79774p103cccjsn4b32f05d3a2f",
            "useQueryString: true"})

//    @GET("timezone")
//    Call<TimeZoneModel> getTimeZone();

    @GET("games")
    Call<GamesModel> getGames(@Query("season") String season, @Query("league") int league);

    @GET("games")
    Call<GamesModel> getGamesbyId(@Query("id") String id);

    @GET("games/h2h")
    Call<GamesModel> getGamesHTH(@Query("h2h") String i);

    @GET("teams")
    Call<TeamsModel> getTeams(@Query("league") int l, @Query("season") String y);

    @GET("teams/statistics")
    Call<TeamStatisticsModel> getStatistics(@Query("league") int l, @Query("season") String y, @Query("team") String t);

}
