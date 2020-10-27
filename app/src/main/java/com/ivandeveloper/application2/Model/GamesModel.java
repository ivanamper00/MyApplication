package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GamesModel {
    @SerializedName("get")
    private String get;
    @SerializedName("errors")
    private List<String> errors = null;
    @SerializedName("results")
    private Integer results;
    @SerializedName("response")
    private List<GameModelResponse> response = null;

    public String getGet() {
        return get;
    }

    public void setGet(String get) {
        this.get = get;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public Integer getResults() {
        return results;
    }

    public void setResults(Integer results) {
        this.results = results;
    }

    public List<GameModelResponse> getResponse() {
        return response;
    }

    public void setResponse(List<GameModelResponse> response) {
        this.response = response;
    }

}
