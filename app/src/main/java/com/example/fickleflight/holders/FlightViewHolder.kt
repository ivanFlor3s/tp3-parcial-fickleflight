package com.example.fickleflight.holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fickleflight.data.model.BestFlight
import com.example.fickleflight.databinding.ItemFlightBinding

class FlightViewHolder(view : View): RecyclerView.ViewHolder(view) {
    private val binding = ItemFlightBinding.bind(view)
    fun bind(flight: BestFlight) {
        binding.aerolineName.text = flight.flights[0].airline
        binding.flightTime.text = flight.total_duration.toString()

        binding.fromAcronym.text = flight.flights[0].departure_airport.id
        binding.fromName.text = flight.flights[0].departure_airport.name

        binding.toAcronym.text = flight.flights[0].arrival_airport.id
        binding.toName.text = flight.flights[0].arrival_airport.name

        binding.flightPrice.text = flight.price.toString()

    }
}