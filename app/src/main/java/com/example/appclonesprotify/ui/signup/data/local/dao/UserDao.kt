package com.example.appclonesprotify.ui.signup.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.appclonesprotify.ui.signup.data.local.model.User

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)
    @Query("SELECT * FROM User WHERE email = :emailOrName OR name = :emailOrName")
    suspend fun getUserByEmailOrName(emailOrName: String): User?
}
