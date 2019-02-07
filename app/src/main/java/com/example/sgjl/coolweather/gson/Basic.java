package com.example.sgjl.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2019/2/3.
 */

public class Basic {

    /* 由于Json中的一些字段可能不太适合直接作为Java字段命名 ，因此使用@SerializedName
     * 将Json city 和 cityName进行关联 ，以便使用gson @SerializedName(Json名)
     */

    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update{
        @SerializedName("loc")
        public String updateTime;
    }
}
