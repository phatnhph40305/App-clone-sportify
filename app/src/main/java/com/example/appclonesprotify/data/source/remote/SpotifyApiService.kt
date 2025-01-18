package com.example.appclonesprotify.data.source.remote
import com.example.appclonesprotify.data.model.AlbumTracks
import com.example.appclonesprotify.data.model.Artist
import com.example.appclonesprotify.data.model.ArtistResponse
import com.example.appclonesprotify.data.model.SearchResponse

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface SpotifyApiService {

    @GET("v1/albums/4aawyAB9vmqN3uQ7FjRGTy/tracks")
    suspend fun getShows(
        @Header("Authorization") accessToken: String,
    ): Response<AlbumTracks>

    @GET("v1/artists")
    suspend fun getArtists(
        @Header("Authorization") authHeader: String,
        @Query("ids") ids: String
    ): Response<ArtistResponse>

    @GET("v1/search")
    suspend fun searchArtists(
        @Header("Authorization") authHeader: String,
        @Query("q") query: String,
        @Query("type") type: String = "artist",
        @Query("limit") limit: Int = 50
    ): Response<SearchResponse>

}
