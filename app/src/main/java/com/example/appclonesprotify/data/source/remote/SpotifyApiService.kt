package com.example.appclonesprotify.data.source.remote

import com.example.appclonesprotify.data.source.ResponseResource
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header


interface SpotifyApiService {

    @GET("v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
    suspend fun getShows(
        @Header("Authorization") accessToken: String,
    ): Response<ResponseResource>


}
