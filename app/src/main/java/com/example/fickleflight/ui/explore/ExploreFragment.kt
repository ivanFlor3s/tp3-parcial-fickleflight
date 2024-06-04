package com.example.fickleflight.ui.explore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fickleflight.R
import com.example.fickleflight.adapter.DestinationAdapter
import com.example.fickleflight.data.Destination
import com.example.fickleflight.databinding.FragmentExploreBinding

class ExploreFragment : Fragment() {

    companion object {
        fun newInstance() = ExploreFragment()
    }

    private val viewModel: ExploreViewModel by viewModels()
    private var _binding: FragmentExploreBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentExploreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val destinationAdapter = DestinationAdapter(getDestinations())

        binding.recyclerViewTrendingDestinations.apply {
            layoutManager =
                LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = destinationAdapter
        }
    }

    private fun getDestinations(): List<Destination> {
        return listOf(
            Destination(R.drawable.boracay_explore_image, "Boracay","Philippines", "5D4N" ),
            Destination(R.drawable.baros_explore_image,"Baros", "Maldives", "7D6N" ),
            Destination(R.drawable.bali_explore_image,"Bali", "Indonesia", "3D2N" ),
            Destination(R.drawable.balawan_explore_image,"Balawan", "Philippines", "3D2N" )
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}