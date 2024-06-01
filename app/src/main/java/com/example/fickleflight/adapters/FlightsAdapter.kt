package com.example.fickleflight.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fickleflight.R
import com.example.fickleflight.data.model.BestFlight
import com.example.fickleflight.holders.FlightViewHolder

class FlightsAdapter(var flights: List<BestFlight> = emptyList(), private val onItemSelected:() -> Unit) : RecyclerView.Adapter<FlightViewHolder>(){

    fun updateList(newList: List<BestFlight>){
        this.flights = newList
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlightViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FlightViewHolder(layoutInflater.inflate(R.layout.item_flight, parent, false))
    }

    override fun getItemCount(): Int {
        return flights.size
    }

    override fun onBindViewHolder(holder: FlightViewHolder, position: Int) {
        val item = flights[position]
        holder.bind(item, onItemSelected)
    }

}