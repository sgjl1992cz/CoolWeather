package com.example.sgjl.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2019/2/3.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More{
        @SerializedName("txt")
        public String info;
    }
}
