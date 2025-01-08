package com.example.appclonesprotify.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.appclonesprotify.R
import com.example.appclonesprotify.utils.token.AccessToken
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_login)

        lifecycleScope.launch {
            AccessToken.getAccessToken()
            Log.d("SpotifyToken", "Access Token: ${AccessToken.getAccessToken()}")
        }



        }
    }