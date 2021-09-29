package com.example.wethercorrect.domain

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wethercorrect.R
import com.example.wethercorrect.data.entites.WeatherResponse
import com.example.wethercorrect.data.entites.Wind
import com.example.wethercorrect.presentation.weather.WeatherScreenState
import kotlinx.android.synthetic.main.items.view.*

class Adapter(): RecyclerView.Adapter<Adapter.Items>() {
    var random = 1
    var items:List<WeatherScreenState> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Items {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items,parent,false)
        return Items(view)
    }

    override fun onBindViewHolder(holder: Items, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class Items(itemView: View): RecyclerView.ViewHolder(itemView){
        var degree = itemView.weatherText
        fun bind(name: WeatherScreenState){
            degree.text = name.success?.wind.toString()
        }
    }


}