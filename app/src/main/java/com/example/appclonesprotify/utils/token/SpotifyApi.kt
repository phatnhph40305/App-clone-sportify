package com.example.appclonesprotify.utils.token

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.Header
import retrofit2.http.POST

interface SpotifyApi {
    @FormUrlEncoded
    @POST("https://accounts.spotify.com/api/token")
    suspend fun  getAccessToken(
        @Header("Authorization") authorization: String,
        @Field("grant_type") grantType: String
    ): Response<TokenResponse>
}

data class TokenResponse(
    val access_token: String,
    val token_type: String,
    val expires_in: Int
)

object RetrofitClient {
    val api: SpotifyApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://accounts.spotify.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(SpotifyApi::class.java)
    }
}
