package com.example.weather

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.weathercast.Interfaces.OnDataRetrievedListener
import com.example.weathercast.Models.Cast
import com.example.weathercast.WeatherCast

class AddTownActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_town)

        val townName:EditText = findViewById(R.id.et_townName)
        val save:Button = findViewById(R.id.bt_save)
        val weatherCast = WeatherCast("metric", getString(R.string.app_id));

        save.setOnClickListener {
            weatherCast.getWeather(townName.text.toString(), object: OnDataRetrievedListener {
                override fun onSuccess(cast: Cast) {
                    val intent = Intent()
                    intent.putExtra("town", cast.getName())

                    setResult(Activity.RESULT_OK, intent)
                    finish()
                }

                override fun onFailure() {
                    Toast.makeText(this@AddTownActivity, "City not found", Toast.LENGTH_SHORT).show()
                }

                override fun conexionFail() {
                    Toast.makeText(this@AddTownActivity, "Connection Fail", Toast.LENGTH_SHORT).show()
                    finish()
                }
            })
        }
    }
}