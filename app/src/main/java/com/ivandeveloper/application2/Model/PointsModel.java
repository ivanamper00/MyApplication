package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class PointsModel {
    @SerializedName("for")
    private ForAgainstTotalAverage _for;
    @SerializedName("against")
    private ForAgainstTotalAverage against;

        public PointsModel(ForAgainstTotalAverage _for, ForAgainstTotalAverage against) {
            super();
            this._for = _for;
            this.against = against;
        }

    public class ForAgainstTotalAverage {

        @SerializedName("total")
        private TotalAverage total;
        @SerializedName("average")
        private TotalAverage average;

        public class TotalAverage {

            @SerializedName("home")
            private double home;
            @SerializedName("away")
            private double away;
            @SerializedName("all")
            private double all;

                public TotalAverage(double home, double away, double all) {
                    super();
                    this.home = home;
                    this.away = away;
                    this.all = all;
                }

            public double getHome() {
                return home;
            }

            public double getAway() {
                return away;
            }

            public double getAll() {
                return all;
            }

        }

        public TotalAverage getTotal() {
            return total;
        }

        public TotalAverage getAverage() {
            return average;
        }

    }

    public ForAgainstTotalAverage getFor() {
        return _for;
    }

    public ForAgainstTotalAverage getAgainst() {
        return against;
    }

}
