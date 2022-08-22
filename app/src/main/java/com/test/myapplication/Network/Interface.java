package com.test.myapplication.Network;

import com.test.myapplication.Latlong;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

public interface Interface {

    @GET("list.php")
    Call<List<Latlong>> getData(@QueryMap Map<String, String> params);
}
