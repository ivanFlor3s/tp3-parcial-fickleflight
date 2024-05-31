package com.example.fickleflight.data.network

import com.example.fickleflight.data.model.FlightsResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

//search?engine=google_flights&api_key=123&departure_id=EZE&arrival_id=MIA&outbound_date=2024-05-31&return_date=2024-06-10
interface FligthsApiService {
    @GET("/search")
    suspend fun getFlights(
        @Query("engine") engine: String,
        @Query("api_key") api_key: String,
        @Query("departure_id") departure_id: String,
        @Query("arrival_id") arrival_id: String,
        @Query("outbound_date") outbound_date: String,
        @Query("return_date") return_date: String
    ): Response<FlightsResponse>
}