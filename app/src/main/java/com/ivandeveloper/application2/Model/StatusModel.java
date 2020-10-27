package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class StatusModel {
    @SerializedName("long")
    private String _long;
    @SerializedName("short")
    private String _short;

        public StatusModel(String _long, String _short) {
            super();
            this._long = _long;
            this._short = _short;
        }

    public String get_long() {
        return _long;
    }

    public String get_short() {
        return _short;
    }
}
