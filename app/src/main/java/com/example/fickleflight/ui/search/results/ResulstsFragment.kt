package com.example.fickleflight.ui.search.results

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fickleflight.R
import com.example.fickleflight.data.model.FlightsResponse
import com.example.fickleflight.data.network.FligthsApiService
import com.example.fickleflight.databinding.FragmentResulstsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ResulstsFragment : Fragment() {

    private lateinit var binding: FragmentResulstsBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentResulstsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val retrofit = getRetrofit()

        //search?engine=google_flights&api_key=123&departure_id=EZE&arrival_id=MIA&outbound_date=2024-05-31&return_date=2024-06-10
        CoroutineScope(Dispatchers.IO).launch {
            val service = retrofit.create(FligthsApiService::class.java)
            val response: Response<FlightsResponse> = service.getFlights("google_flights", "123", "EZE", "MIA", "2024-05-31", "2024-06-10")
            if (response.isSuccessful) {
                Log.i("FlightsResponse :)", response.body().toString())
                /*val flights = response.body()
                flights?.let {
                    withContext(Dispatchers.Main) {
                        binding.tvBestFlight.text = it.best_flights.toString()
                        binding.tvOtherFlights.text = it.other_flights.toString()
                        binding.tvPriceInsights.text = it.price_insights.toString()
                        binding.tvSearchMetadata.text = it.search_metadata.toString()
                        binding.tvSearchParameters.text = it.search_parameters.toString()
                    }
                }*/
            }else {
                Log.i("FlightsResponse :(", response.errorBody().toString())
            }
        }

        return root
    }

    private fun getRetrofit(): Retrofit {
        val baseUrl = "https://d9811bf4-5e67-4a8c-bdcf-603cbbfc0275.mock.pstmn.io/"
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit
    }




}