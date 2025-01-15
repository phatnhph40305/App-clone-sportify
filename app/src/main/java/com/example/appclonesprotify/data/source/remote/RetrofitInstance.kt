package com.example.appclonesprotify.data.source.remote

import okhttp3.Interceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {


    private const val BASE_URL = "https://api.spotify.com/"
    val retrofit: SpotifyApiService by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpotifyApiService::class.java)
    }


}