package com.example.weather

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.weathercast.Interfaces.OnDataRetrievedListener
import com.example.weathercast.Models.Cast
import com.example.weathercast.WeatherCast

/**
 * Activity to show detail of the weather cast for a town
 * populate townd detail
 * handle the use offline
 * if not cached and no response finish() and back to mainactivity
 */
class TownDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_town_details)

        val cityName: TextView = findViewById(R.id.tv_cityName)
        val temperature: TextView = findViewById(R.id.tv_temp)
        val description: TextView = findViewById(R.id.tv_description)
        val icon: ImageView = findViewById(R.id.iv_icon)
        val feels_like: TextView = findViewById(R.id.tv_feels)
        val temp_min: TextView = findViewById(R.id.tv_temp_min)
        val temp_max: TextView = findViewById(R.id.tv_temp_max)
        val pressure: TextView = findViewById(R.id.tv_pressure)
        val humidity: TextView = findViewById(R.id.tv_humidity)

        val town = intent.getStringExtra("town")
        val weatherCast = WeatherCast("metric", getString(R.string.app_id), cacheDir, Utils().isConnected(this));

        weatherCast.getWeather(town, object: OnDataRetrievedListener {
            override fun onSuccess(cast: Cast) {
                cityName.text = cast.getName()
                temperature.text = cast.getMain()?.getTemp().toString() + " °c"
                description.text = cast.getWeather()?.get(0)?.getDescription()
                feels_like.text = cast.getMain()?.getFeelsLike().toString() + " °c"
                temp_min.text = cast.getMain()?.getTempMin().toString() + " °c"
                temp_max.text = cast.getMain()?.getTempMax().toString() + " °c"
                pressure.text = cast.getMain()?.getPressure().toString()
                humidity.text = cast.getMain()?.getHumidity().toString()

                val ic: String? = "_" + cast.getWeather()?.get(0)?.getIcon()


                val idFiled = resources.getIdentifier(ic,"drawable", packageName)
                if (idFiled != 0) {
                    icon.setImageDrawable(ContextCompat.getDrawable(applicationContext, idFiled))
                }
            }

            override fun onFailure() {
                Toast.makeText(this@TownDetailsActivity, "City not found", Toast.LENGTH_SHORT).show()
            }

            override fun connectionFail() {
                Toast.makeText(this@TownDetailsActivity, "Connection Fail", Toast.LENGTH_SHORT).show()
                finish()
            }
        })
    }
}