package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class PlayersModel {
    @SerializedName("PlayerID")
    private String playerID;
    @SerializedName("SportsDataID")
    private String sportsDataID;
    @SerializedName("Status")
    private String status;
    @SerializedName("TeamID")
    private String teamID;
    @SerializedName("Team")
    private String team;
    @SerializedName("Jersey")
    private String jersey;
    @SerializedName("PositionCategory")
    private String positionCategory;
    @SerializedName("Position")
    private String position;
    @SerializedName("MLBAMID")
    private String mLBAMID;
    @SerializedName("FirstName")
    private String firstName;
    @SerializedName("LastName")
    private String lastName;
    @SerializedName("BatHand")
    private String batHand;
    @SerializedName("ThrowHand")
    private String throwHand;
    @SerializedName("Height")
    private String height;
    @SerializedName("Weight")
    private String weight;
    @SerializedName("ProDebut")
    private String proDebut;
    @SerializedName("PhotoUrl")
    private String photoUrl;
    @SerializedName("Experience")
    private String experience;

    public PlayersModel(String playerID, String sportsDataID, String status, String teamID, String team, String jersey, String positionCategory, String position, String mLBAMID, String firstName, String lastName, String batHand, String throwHand, String height, String weight, String proDebut, String photoUrl, String experience) {
        this.playerID = playerID;
        this.sportsDataID = sportsDataID;
        this.status = status;
        this.teamID = teamID;
        this.team = team;
        this.jersey = jersey;
        this.positionCategory = positionCategory;
        this.position = position;
        this.mLBAMID = mLBAMID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.batHand = batHand;
        this.throwHand = throwHand;
        this.height = height;
        this.weight = weight;
        this.proDebut = proDebut;
        this.photoUrl = photoUrl;
        this.experience = experience;
    }

    public PlayersModel(String playerID, String jersey, String lastName, String photoUrl) {
        this.playerID = playerID;
        this.jersey = jersey;
        this.lastName = lastName;
        this.photoUrl = photoUrl;
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getSportsDataID() {
        return sportsDataID;
    }

    public String getStatus() {
        return status;
    }

    public String getTeamID() {
        return teamID;
    }

    public String getTeam() {
        return team;
    }

    public String getJersey() {
        return jersey;
    }

    public String getPositionCategory() {
        return positionCategory;
    }

    public String getPosition() {
        return position;
    }

    public String getmLBAMID() {
        return mLBAMID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBatHand() {
        return batHand;
    }

    public String getThrowHand() {
        return throwHand;
    }

    public String getHeight() {
        return height;
    }

    public String getWeight() {
        return weight;
    }

    public String getProDebut() {
        return proDebut;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getExperience() {
        return experience;
    }
}
