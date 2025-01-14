package com.example.appclonesprotify.data.source.remote

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import com.example.appclonesprotify.data.model.PlaylistTracksResponse
import retrofit2.Response


interface SpotifyApiService {
    @GET("v1/playlists/{playlist_id}/tracks")
    suspend fun getPlaylistTracks(
        @Header("Authorization") authorization: String,
        @Path("playlist_id") playlistId: String
    ): Response<PlaylistTracksResponse>
}
