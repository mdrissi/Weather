package com.example.weather

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Rect
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class MainActivity : AppCompatActivity() {
    private val requestCode = 42
    var townList = ArrayList<String>()
    private lateinit var adapter:TownListAdapter
    private lateinit var sharedPreferences:SharedPreferences

    /**
     *
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = applicationContext.getSharedPreferences("Cities", Context.MODE_PRIVATE)
        val json = sharedPreferences.getString("cities", "")
        if (json != null) {
            if (json.isNotEmpty()) {
                val type:Type = object : TypeToken<List<String>>() {}.type
                townList = Gson().fromJson(json, type)
            }
        }
        val addTown:Button = findViewById(R.id.bt_addTown);
        val rv_townList:RecyclerView = findViewById(R.id.rv_townList);

        addTown.setOnClickListener{
            startActivityForResult(Intent(this@MainActivity, AddTownActivity::class.java), requestCode)
        }

        val rvManager = LinearLayoutManager(this)
        rv_townList.layoutManager = rvManager
        rv_townList.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.bottom = resources.getDimension(R.dimen.margin_btn).toInt()
            }
        })

        adapter = TownListAdapter(townList)
        rv_townList.adapter = adapter
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == this.requestCode) {
            if (data != null) {
                val town: String = data.getStringExtra("town")
                if (townList.contains(town))
                    return

                Toast.makeText(this@MainActivity, "City added successfully", Toast.LENGTH_SHORT).show()
                townList.add(town)
                adapter.notifyDataSetChanged()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        val json = Gson().toJson(townList)
        val editor:SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("cities", json)
        editor.apply()
    }

    override fun onDestroy() {
        super.onDestroy()
        val json = Gson().toJson(townList)
        val editor:SharedPreferences.Editor = sharedPreferences.edit()
        editor.putString("cities", json)
        editor.apply()

    }
}