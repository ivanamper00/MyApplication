package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class CountryModel {

        @SerializedName("id")
        private Integer id;
        @SerializedName("name")
        private String name;
        @SerializedName("code")
        private String code;
        @SerializedName("flag")
        private String flag;

            public CountryModel(Integer id, String name, String code, String flag) {
                super();
                this.id = id;
                this.name = name;
                this.code = code;
                this.flag = flag;
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getFlag() {
            return flag;
        }

        public void setFlag(String flag) {
            this.flag = flag;
        }


}


