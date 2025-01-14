package com.example.appclonesprotify.ui


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.appclonesprotify.databinding.ActivityMainBinding
import com.example.appclonesprotify.utils.token.AccessToken
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import com.example.appclonesprotify.ui.viewmodel.PlayListTraksViewModel


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
    }
}


