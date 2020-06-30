package com.example.weathercast

import com.example.weathercast.Interfaces.OnDataRetrievedListener
import com.example.weathercast.Models.Cast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.File

/**
 * TODO
 *
 * @property units
 * @property appID
 * @constructor
 * instantiate appretrofit
 *
 * @param cacheDir
 * @param isConnected
 */
class WeatherCast(private val units: String, private val appID: String, cacheDir: File, isConnected: Boolean) {
    private val appRetrofit:AppRetrofit = AppRetrofit(cacheDir , isConnected)

    /**
     * get The Weather
     *
     * @param town
     * @param onDataRetrievedListener
     */
    fun getWeather(town:String, onDataRetrievedListener:OnDataRetrievedListener) {
        appRetrofit
            .getService()
            ?.getWeather(town, units, appID)
            ?.enqueue(object: Callback<Cast?> {
                override fun onResponse(
                    call: Call<Cast?>,
                    response: Response<Cast?>
                ) {
                    if (response.isSuccessful)
                        response.body()?.let { onDataRetrievedListener.onSuccess(it) }
                    else
                        onDataRetrievedListener.onFailure()
                }

                override fun onFailure(
                    call: Call<Cast?>,
                    t: Throwable
                ) {
                    t.printStackTrace()
                    onDataRetrievedListener.connectionFail()

                }
            })
    }
}
