package com.example.appclonesprotify.ui.signup.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

    @Entity
    data class User(
        @PrimaryKey val email: String,
        val password: String,
        val name: String,
        val gender: String = ""
    )
