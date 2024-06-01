package com.example.fickleflight.holders

import android.annotation.SuppressLint
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.fickleflight.data.model.BestFlight
import com.example.fickleflight.databinding.ItemFlightBinding

class FlightViewHolder(view : View): RecyclerView.ViewHolder(view) {
    private val binding = ItemFlightBinding.bind(view)
    @SuppressLint("SetTextI18n")
    fun bind(flight: BestFlight) {
        binding.aerolineName.text = flight.flights[0].airline
        binding.flightTime.text = convertMinutesToReadableTime(flight.total_duration)

        binding.fromAcronym.text = flight.flights[0].departure_airport.id
        binding.fromName.text = flight.flights[0].departure_airport.name

        binding.toAcronym.text = flight.flights[0].arrival_airport.id
        binding.toName.text = flight.flights[0].arrival_airport.name

        val price = flight.price.toString()
        binding.flightPrice.text = "$ $price"

    }

    private fun convertMinutesToReadableTime(minutes: Int): String {
        val minutesInADay = 24 * 60

        return if (minutes > minutesInADay) {
            "+24hs"
        } else {
            val hours = minutes / 60
            val remainingMinutes = minutes % 60
            "${hours}h ${remainingMinutes}m"
        }
    }
}