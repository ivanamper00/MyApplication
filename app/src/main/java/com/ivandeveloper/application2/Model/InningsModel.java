package com.ivandeveloper.application2.Model;

import com.google.gson.annotations.SerializedName;

public class InningsModel {
    @SerializedName("1")
    private String _1;
    @SerializedName("2")
    private String _2;
    @SerializedName("3")
    private String _3;
    @SerializedName("4")
    private String _4;
    @SerializedName("5")
    private String _5;
    @SerializedName("6")
    private String _6;
    @SerializedName("7")
    private String _7;
    @SerializedName("8")
    private String _8;
    @SerializedName("9")
    private String _9;
    @SerializedName("extra")
    private Object extra;

        public InningsModel(String _1, String _2, String _3, String _4, String _5, String _6, String _7, String _8, String _9, Object extra) {
            super();
            this._1 = _1;
            this._2 = _2;
            this._3 = _3;
            this._4 = _4;
            this._5 = _5;
            this._6 = _6;
            this._7 = _7;
            this._8 = _8;
            this._9 = _9;
            this.extra = extra;
        }

    public String get1() {
        return _1;
    }

    public void set1(String _1) {
        this._1 = _1;
    }

    public String get2() {
        return _2;
    }

    public void set2(String _2) {
        this._2 = _2;
    }

    public String get3() {
        return _3;
    }

    public void set3(String _3) {
        this._3 = _3;
    }

    public String get4() {
        return _4;
    }

    public void set4(String _4) {
        this._4 = _4;
    }

    public String get5() {
        return _5;
    }

    public void set5(String _5) {
        this._5 = _5;
    }

    public String get6() {
        return _6;
    }

    public void set6(String _6) {
        this._6 = _6;
    }

    public String get7() {
        return _7;
    }

    public void set7(String _7) {
        this._7 = _7;
    }

    public String get8() {
        return _8;
    }

    public void set8(String _8) {
        this._8 = _8;
    }

    public String get9() {
        return _9;
    }

    public void set9(String _9) {
        this._9 = _9;
    }

    public Object getExtra() {
        return extra;
    }

    public void setExtra(Object extra) {
        this.extra = extra;
    }
}
