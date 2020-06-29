package com.example.weather

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.example.weathercast.WeatherCast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addTown:Button = findViewById(R.id.bt_addTown);
        val townList:RecyclerView = findViewById(R.id.rv_townList);

        addTown.setOnClickListener{
            startActivity(Intent(this@MainActivity, AddTownActivity::class.java))
        }



    }
}