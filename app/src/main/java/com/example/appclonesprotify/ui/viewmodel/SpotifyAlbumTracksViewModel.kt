package com.example.appclonesprotify.ui.viewmodel

import com.example.appclonesprotify.data.model.AlbumTracks
import com.example.appclonesprotify.data.source.remote.RetrofitInstance
import com.example.appclonesprotify.utils.token.AccessToken

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SpotifyAlbumTracksViewModel : ViewModel() {
    private val _tracks = MutableLiveData<AlbumTracks?>()
    val tracks: LiveData<AlbumTracks?> = _tracks

    init {
        loadData()
    }

   private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitInstance.retrofit.getShows("Bearer ${AccessToken.getAccessToken()}")
            val albumTracks = response.body()
            if(albumTracks != null && response.isSuccessful){
                _tracks.postValue(albumTracks)
            }          else {
                _tracks.postValue(null)
            }


        }
    }

}