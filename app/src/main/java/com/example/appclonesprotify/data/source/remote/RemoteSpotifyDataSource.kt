package com.example.appclonesprotify.data.source.remote
import com.example.appclonesprotify.data.source.SpotifyDataSource
import com.example.appclonesprotify.data.source.ResponseResource
import com.example.appclonesprotify.utils.token.AccessToken


class RemoteSpotifyDataSource() :
    SpotifyDataSource {
    override suspend fun loadData(callBack: SpotifyDataSource.DataSourceCallBack) {
        val retrofit =
            RetrofitInstance.retrofit.getShows("Bearer ${AccessToken.getAccessToken()!!}")

        val data = retrofit.body()
        if (data != null) {
        callBack.completed(ResponseResource.Success(data))
        }else{
            callBack.completed(ResponseResource.ErrorResponse(Exception(retrofit.message())))
        }

    }

}