package com.example.appclonesprotify.ui


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appclonesprotify.data.source.SelectedDataSource
import com.example.appclonesprotify.data.source.SpotifyDataRepository
import com.example.appclonesprotify.data.source.remote.RemoteSpotifyDataSource
import com.example.appclonesprotify.databinding.ActivityMainBinding
import com.example.appclonesprotify.ui.viewmodel.PlayListTracksViewModel
import com.example.appclonesprotify.ui.viewmodel.SpotifyViewModelFactory
import com.example.appclonesprotify.utils.token.AccessToken
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        lifecycleScope.launch {
            Log.d("SpotifyToken", "Access Token: ${AccessToken.getAccessToken()}")
        }
        runBlocking {
        }
        binding.navHostFragmentContainer.post {
            val navController = binding.navHostFragmentContainer.findNavController()
            binding.menu.setupWithNavController(navController)
        }

        setUpViewModel()


    }

    private fun setUpViewModel() {

        val remoteDataSource: RemoteSpotifyDataSource = RemoteSpotifyDataSource()
        val selectedDataSource = SelectedDataSource.REMOTE

        val spotifyDataRepository =SpotifyDataRepository(selectedDataSource , remoteDataSource)

        val spotifyViewModel = ViewModelProvider(this , SpotifyViewModelFactory(spotifyDataRepository))[PlayListTracksViewModel::class.java]


        spotifyViewModel.data.observe(this){data ->
            Log.d("Data" , data.toString())

        }
    }
}


