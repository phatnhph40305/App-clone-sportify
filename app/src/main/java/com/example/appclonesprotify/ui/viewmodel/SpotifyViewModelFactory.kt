package com.example.appclonesprotify.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.example.appclonesprotify.data.source.SpotifyDataRepository
import com.example.appclonesprotify.ui.viewmodel.PlayListTracksViewModel

import androidx.lifecycle.ViewModelProvider

class SpotifyViewModelFactory(val repository: SpotifyDataRepository) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlayListTracksViewModel::class.java)) {
            return PlayListTracksViewModel(repository) as T
        } else {
            throw IllegalArgumentException("Argument is not class PlayListTracksViewModel")
        }
    }

}