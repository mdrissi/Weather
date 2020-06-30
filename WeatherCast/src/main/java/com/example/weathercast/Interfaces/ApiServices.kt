package com.example.weathercast.Interfaces

import com.example.weathercast.Models.Cast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Api Serivces
 *
 */
interface ApiServices {
    @GET("data/2.5/weather?")
    fun getWeather(
        @Query("q") query:String?,
        @Query("units") units: String?,
        @Query("appid") appID:String?
    ): Call<Cast?>?
}