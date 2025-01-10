package com.example.appclonesprotify.ui.signup.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.appclonesprotify.ui.signup.data.local.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
}
