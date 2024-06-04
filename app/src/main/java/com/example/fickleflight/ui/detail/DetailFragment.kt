package com.example.fickleflight.ui.detail

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.fickleflight.R
import com.example.fickleflight.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private lateinit var  _binding: FragmentDetailBinding

    companion object {
        fun newInstance() = DetailFragment()
    }

    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        _binding.backFloatingActionButton.setOnClickListener(View.OnClickListener {
            Log.i("DetailFragment", "Go back button clicked")
            findNavController().popBackStack()
        })
        return _binding.root
    }
}