package com.example.appclonesprotify.ui



import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope

import com.example.appclonesprotify.ui.login.LoginActivity
import com.example.appclonesprotify.utils.token.AccessToken
import kotlinx.coroutines.delay

import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

import kotlinx.coroutines.launch
import com.example.appclonesprotify.databinding.ActivityMainBinding
import com.example.appclonesprotify.R

class MainActivity : AppCompatActivity() {

   private  val binding  by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        lifecycleScope.launch {
            AccessToken.getAccessToken()
            Log.d("SpotifyToken", "Access Token: ${AccessToken.getAccessToken()}")
        }
        binding.navHostFragmentContainer.post{
            val navController = binding.navHostFragmentContainer.findNavController()
            binding.menu.setupWithNavController(navController)
        }
    }
}


