package com.example.weather

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 * The adapter for the townlist
 *
 * @constructor
 *
 *
 * @param townList
 */
class TownListAdapter(townList: ArrayList<String>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var data = ArrayList<String>()

    init {
        data = townList
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_town, parent, false)

        return TownViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TownViewHolder).bind(data[position])
    }
}