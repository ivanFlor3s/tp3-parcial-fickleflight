package com.example.fickleflight.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fickleflight.data.model.BestFlight
import com.example.fickleflight.databinding.ItemFlightBinding

class FlightViewHolder(view : View): RecyclerView.ViewHolder(view) {
    private val binding = ItemFlightBinding.bind(view)
    fun bind(flight: BestFlight) {
        binding.flightName.text = flight.flights[0].airline
    }
}