package com.example.fickleflight.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.fickleflight.data.Destination
import com.example.fickleflight.databinding.ItemDestinationBinding

class DestinationAdapter(private val destinations: List<Destination>) :
    RecyclerView.Adapter<DestinationAdapter.DestinationViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DestinationViewHolder {
        val binding = ItemDestinationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DestinationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DestinationViewHolder, position: Int) {
        val destination = destinations[position]
        holder.bind(destination)
    }

    override fun getItemCount() = destinations.size

    class DestinationViewHolder(private val binding: ItemDestinationBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(destination: Destination) {
            binding.imageView.setImageResource(destination.imageResId)
            binding.textViewDestination.text = destination.name
            binding.textViewCountry.text = destination.country
            binding.offer2Title.text = destination.duration
        }
    }
}