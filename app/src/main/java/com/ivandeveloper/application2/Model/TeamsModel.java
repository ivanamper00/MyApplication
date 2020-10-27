package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TeamsModel {

    @SerializedName("response")
    public List<TeamsModel.Response> response = null;

        public static class Response{
            @SerializedName("id")
            private Integer id;
            @SerializedName("name")
            private String name;
            @SerializedName("logo")
            private String logo;
            @SerializedName("nationnal")
            private Boolean nationnal;
            @SerializedName("country")
            private CountryModel country;

            public Response(Integer id, String name, String logo, Boolean nationnal, CountryModel country){
                super();
                this.id = id;
                this.name = name;
                this.logo = logo;
                this.nationnal = nationnal;
                this.country = country;
            }
            public Response(Integer id, String name, String logo,CountryModel country){
                super();
                this.id = id;
                this.name = name;
                this.logo = logo;
            }

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getLogo() {
                return logo;
            }

            public void setLogo(String logo) {
                this.logo = logo;
            }

            public Boolean getNationnal() {
                return nationnal;
            }

            public void setNationnal(Boolean nationnal) {
                this.nationnal = nationnal;
            }

            public CountryModel getCountry() {
                return country;
            }

            public void setCountry(CountryModel country) {
                this.country = country;
            }
        }

    public List<TeamsModel.Response> getResponse() {
        return response;
    }
    public void setResponse(List<TeamsModel.Response> response) {
        this.response = response;
    }

}
