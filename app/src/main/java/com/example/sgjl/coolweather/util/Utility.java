package com.example.sgjl.coolweather.util;

import android.text.TextUtils;

import com.example.sgjl.coolweather.db.City;
import com.example.sgjl.coolweather.db.County;
import com.example.sgjl.coolweather.db.Province;
import com.example.sgjl.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2019/2/1.
 */

public class Utility {
    public static final String SERVER = "http://guolin.tech/api/";
    public static final String CHINA = "china";
    public static final String WEATHER = "weather";
    public static final String KEY = "bade04f2ee6249de801e882e3866b903";

    /*
    解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String response){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray allProvince = new JSONArray(response);
                for (int i = 0; i < allProvince.length(); i++) {
                    JSONObject provinceObject = allProvince.getJSONObject(i);
                    Province province = new Province();
                    province.setProviceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;

            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
        解析和处理服务器返回的市级数据
    */
    public static boolean handleCityResponse(String response,int provinceID){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray allCities = new JSONArray(response);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceID);
                    city.save();
                }
                return true;

            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
        解析和处理服务器返回的县级数据
    */
    public static boolean handleCountyResponse(String response,int cityId){
        if (!TextUtils.isEmpty(response)){
            try{
                JSONArray allCounty = new JSONArray(response);
                for (int i = 0; i < allCounty.length(); i++) {
                    JSONObject countyObject = allCounty.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;

            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /*
    将返回的Json解析为Weather实体类
     */
    public static Weather handleWeatherResponse(String response){
        try{
            JSONObject jsonObject = new JSONObject(response);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
