package com.example.weather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.weathercast.WeatherCast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherCast:WeatherCast = WeatherCast("metric", getString(R.string.app_id));

        weatherCast.getWeather("Berlin");
    }
}