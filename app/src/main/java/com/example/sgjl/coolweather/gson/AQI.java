package com.example.sgjl.coolweather.gson;

/**
 * Created by Administrator on 2019/2/3.
 */

public class AQI {
    public AQICity city;
    public class AQICity{
        public String api;
        public String pm25;
    }
}
