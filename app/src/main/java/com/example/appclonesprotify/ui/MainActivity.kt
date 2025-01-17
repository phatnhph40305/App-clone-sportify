package com.example.appclonesprotify.ui


import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appclonesprotify.databinding.ActivityMainBinding
import com.example.appclonesprotify.utils.token.AccessToken
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import com.example.appclonesprotify.ui.viewmodel.SpotifyAlbumTracksViewModel
import com.google.gson.Gson
import com.example.appclonesprotify.services.PlayMusicService


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

        val viewModel = ViewModelProvider(this)[SpotifyAlbumTracksViewModel::class.java]
        viewModel.tracks.observe(this){track ->
            Log.d("Data from viewmodel" , Gson().toJson(track.toString()) )

        }


    }

    override fun onDestroy() {
        super.onDestroy()
        val intent = Intent(this , PlayMusicService::class.java)
        stopService(intent)
    }
}



