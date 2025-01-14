package com.example.appclonesprotify.data.source.remote

import com.example.appclonesprotify.data.source.SpotifyDataSource
import com.example.appclonesprotify.data.source.ResponseResource


class RemoteSpotifyDataSource(private val accessToken: String, private val playListId: String) :
    SpotifyDataSource {
    override suspend fun loadData(callBack: SpotifyDataSource.DataSourceCallBack) {
        val retrofit = RetrofitInstance.retrofit?.create(SpotifyApiService::class.java)
        val response = retrofit?.getPlaylistTracks(accessToken, playListId)!!

        callBack.completed(ResponseResource.Success(response.body()))


    }

}