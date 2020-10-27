package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class ScoreModel {
    @SerializedName("hits")
    private int hits;
    @SerializedName("errors")
    private int errors;
    @SerializedName("innings")
    private InningsModel innings;
    @SerializedName("total")
    private int total;

        public ScoreModel(int hits, int errors, InningsModel innings, int total) {
            super();
            this.hits = hits;
            this.errors = errors;
            this.innings = innings;
            this.total = total;
        }

    public int getHits() {
        return hits;
    }

    public int getErrors() {
        return errors;
    }

    public InningsModel getInnings() {
        return innings;
    }

    public int getTotal() {
        return total;
    }




}
