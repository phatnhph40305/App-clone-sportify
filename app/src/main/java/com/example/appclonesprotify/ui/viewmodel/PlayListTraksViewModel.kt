package com.example.appclonesprotify.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appclonesprotify.data.model.AlbumTracks
import com.example.appclonesprotify.data.source.ResponseResource
import com.example.appclonesprotify.data.source.remote.RetrofitInstance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.appclonesprotify.data.source.SpotifyDataSource
import com.example.appclonesprotify.data.source.SpotifyDataRepository

import com.example.appclonesprotify.utils.token.AccessToken


class PlayListTracksViewModel(
    private val spotifyRepository: SpotifyDataRepository
) :
    ViewModel() {
    private val _data = MutableLiveData<AlbumTracks?>()
    val data: LiveData<AlbumTracks?> = _data

    init {
        loadData()
    }
@Suppress("unchecked_cast")
    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {

            val callback = object : SpotifyDataSource.DataSourceCallBack {
                override fun completed(responseResource: ResponseResource) {

                    if (responseResource is ResponseResource.Success<*>) {
                        val dataMusic = (responseResource as ResponseResource.Success<AlbumTracks>).data
                        _data.postValue(dataMusic)
                    }else{
                        _data.postValue(null)
                    }



                }

            }
            spotifyRepository.loadData(callback)
        }



    }

}