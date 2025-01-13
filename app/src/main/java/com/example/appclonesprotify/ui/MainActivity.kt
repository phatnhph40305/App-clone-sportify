package com.example.appclonesprotify.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavGraph
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.appclonesprotify.utils.token.AccessToken
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
        binding.navHostFragmentContainer.post{
            val navController = binding.navHostFragmentContainer.findNavController()
            binding.menu.setupWithNavController(navController)
        }







        }
    }