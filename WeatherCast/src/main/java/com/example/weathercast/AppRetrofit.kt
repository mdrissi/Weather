package com.example.weathercast

import com.example.weathercast.Interfaces.ApiServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class AppRetrofit {
    private val PARENT_URL = "https://api.openweathermap.org/"

    private var apiServices: ApiServices? = null

    init {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(PARENT_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
        apiServices = retrofit.create(ApiServices::class.java)
    }

    fun getService(): ApiServices? {
        return apiServices
    }
}