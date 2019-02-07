package com.example.sgjl.coolweather.gson;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2019/2/3.
 */

public class Weather {

    public String status;
    public Basic basic;
    public AQI api;
    public Now now;
    public Suggestion suggestion;

    @SerializedName("daily_forecast")
    public List<Forecast> forecastList;
}
