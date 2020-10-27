package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class TeamStatisticsModel {

    @SerializedName("response")
    private TeamStatisticsModelResponse response;

    public TeamStatisticsModel(TeamStatisticsModelResponse response) {
        super();
        this.response = response;
    }

    public TeamStatisticsModelResponse getResponse() {
        return response;
    }

    public void setResponse(TeamStatisticsModelResponse response) {
        this.response = response;
    }

}
