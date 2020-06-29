package com.example.weather

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TownViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val cityName:TextView = itemView.findViewById(R.id.tv_cityName)

    fun bind(city: String) {
        cityName.text = city
    }
}