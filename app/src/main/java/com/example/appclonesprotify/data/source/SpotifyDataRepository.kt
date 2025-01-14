package com.example.appclonesprotify.data.source

import com.example.appclonesprotify.data.source.remote.RemoteSpotifyDataSource


class SpotifyDataRepository(
    private val selectedDataSource: SelectedDataSource,
    private val remoteSpotifyDataSource: RemoteSpotifyDataSource
) {

    suspend fun loadData(callBack: SpotifyDataSource.DataSourceCallBack) {
        if(selectedDataSource == SelectedDataSource.REMOTE){
            remoteSpotifyDataSource.loadData(callBack)
        }

    }
}