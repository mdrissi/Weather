package com.example.weathercast

import com.example.weathercast.Models.Cast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherCast(private val units: String, private val appID: String) {
    private val appRetrofit:AppRetrofit = AppRetrofit()

    fun getWeather(town:String) {
        appRetrofit
            .getService()
            ?.getWeather(town, units, appID)
            ?.enqueue(object: Callback<Cast?> {
                override fun onResponse(
                    call: Call<Cast?>,
                    response: Response<Cast?>
                ) {
                    println(response.code());
                }

                override fun onFailure(
                    call: Call<Cast?>,
                    t: Throwable
                ) {
                    t.printStackTrace()
                }
            })
    }
}
