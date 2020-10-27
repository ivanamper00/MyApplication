package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class HomeAwayScoreModel {
    @SerializedName("hits")
    private int hits;
    @SerializedName("errors")
    private int errors;
    @SerializedName("innings")
    private InningsModel innings;
    @SerializedName("total")
    private int total;

        public HomeAwayScoreModel(int hits, int errors, InningsModel innings, int total) {
            super();
            this.hits = hits;
            this.errors = errors;
            this.innings = innings;
            this.total = total;
        }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public int getErrors() {
        return errors;
    }

    public void setErrors(int errors) {
        this.errors = errors;
    }

    public InningsModel getInnings() {
        return innings;
    }

    public void setInnings(InningsModel innings) {
        this.innings = innings;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
}

