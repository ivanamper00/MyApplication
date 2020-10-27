package com.ivandeveloper.application2.Database;

import com.ivandeveloper.application2.Model.PlayersModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface MlbApi {

    String BASE_URL = "https://api.sportsdata.io/v3/mlb/scores/json/";

//    @Headers("Ocp-Apim-Subscription-Key: d40cdb544910484b9d4eb3f570e8a6a6")

    @GET("Players?key=d40cdb544910484b9d4eb3f570e8a6a6")
    Call<List<PlayersModel>> getPlayers() ;

    @GET("Player/{playerID}?key=d40cdb544910484b9d4eb3f570e8a6a6")
    Call<PlayersModel> getPlayer(@Path("playerID") String id);
}
