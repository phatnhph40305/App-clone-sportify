package com.example.appclonesprotify.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appclonesprotify.data.model.PlaylistTracksResponse
import com.example.appclonesprotify.data.source.ResponseResource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.appclonesprotify.data.source.SpotifyDataSource
import com.example.appclonesprotify.data.source.SpotifyDataRepository



class PlayListTraksViewModel(val spotifyDataRepository : SpotifyDataRepository ) : ViewModel() {
    private val _data= MutableLiveData<PlaylistTracksResponse>()
    val data: LiveData<PlaylistTracksResponse> = _data

    @Suppress("uncheck_cast")
   private fun loadData(){
        viewModelScope.launch(Dispatchers.IO) {
            val callback  = object : SpotifyDataSource.DataSourceCallBack{
                override fun completed(responseResource: ResponseResource) {
                    if(responseResource is ResponseResource.Success<*>){
                        val dataRemote = (responseResource as ResponseResource.Success<PlaylistTracksResponse>).data
                            _data.postValue(dataRemote)
                    }
                }


            }
            spotifyDataRepository.loadData(callback)
        }
    }

}