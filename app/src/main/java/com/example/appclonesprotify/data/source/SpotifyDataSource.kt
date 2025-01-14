package com.example.appclonesprotify.data.source

interface SpotifyDataSource {
    suspend fun loadData(callBack: DataSourceCallBack)

    interface DataSourceCallBack{
        fun completed(responseResource: ResponseResource)
    }
}