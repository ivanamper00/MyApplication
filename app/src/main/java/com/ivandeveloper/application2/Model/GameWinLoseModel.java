package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class GameWinLoseModel {
    @SerializedName("played")
    private Played played;
    @SerializedName("wins")
    private WinLoses wins;
    @SerializedName("loses")
    private WinLoses loses;

    public GameWinLoseModel(Played played, WinLoses wins, WinLoses loses) {
        super();
        this.played = played;
        this.wins = wins;
        this.loses = loses;
    }

    public class WinLoses {

        @SerializedName("home")
        private homeAwayTotalPercentage home;
        @SerializedName("away")
        private homeAwayTotalPercentage away;
        @SerializedName("all")
        private homeAwayTotalPercentage all;

        public WinLoses(homeAwayTotalPercentage home, homeAwayTotalPercentage away, homeAwayTotalPercentage all) {
            super();
            this.home = home;
            this.away = away;
            this.all = all;
        }
        public class homeAwayTotalPercentage {

            @SerializedName("total")
            private Integer total;
            @SerializedName("percentage")
            private Object percentage;

            public Integer getTotal() {
                return total;
            }

            public void setTotal(Integer total) {
                this.total = total;
            }

            public Object getPercentage() {
                return percentage;
            }

            public void setPercentage(Object percentage) {
                this.percentage = percentage;
            }

        }

        public homeAwayTotalPercentage getHome() {
            return home;
        }

        public homeAwayTotalPercentage getAway() {
            return away;
        }

        public homeAwayTotalPercentage getAll() {
            return all;
        }
    }
    public class Played {

        @SerializedName("home")
        private Integer home;
        @SerializedName("away")
        private Integer away;
        @SerializedName("all")
        private Integer all;

        public Played(Integer home, Integer away, Integer all) {
            super();
            this.home = home;
            this.away = away;
            this.all = all;
        }

        public Integer getHome() {
            return home;
        }

        public Integer getAway() {
            return away;
        }

        public Integer getAll() {
            return all;
        }
    }

    public Played getPlayed() {
        return played;
    }

    public WinLoses getWins() {
        return wins;
    }

    public WinLoses getLoses() {
        return loses;
    }
}
