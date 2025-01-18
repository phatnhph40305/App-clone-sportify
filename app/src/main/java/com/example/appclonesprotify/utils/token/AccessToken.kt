package com.example.appclonesprotify.utils.token

import android.util.Base64
import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

object AccessToken {

    private const val clientId = "9a8025ea0aa64258bee27065ae686e28"
    private const val clientSecret = "1655456b30d64b728f70317308eb444e"
     var accessToken: String? = null

    // Hàm lấy access token
    suspend fun getAccessToken(): String? {
        if (accessToken != null) {
            return accessToken  // Trả về token nếu đã có
        }

        // Nếu chưa có atoken, gọi API để lấy token mới
        val credentials = "$clientId:$clientSecret"
        val base64Credentials = Base64.encodeToString(credentials.toByteArray(), Base64.NO_WRAP)
        val authorization = "Basic $base64Credentials"
        val grantType = "client_credentials"

        val response: Response<TokenResponse> = withContext(Dispatchers.IO) {
            RetrofitClient.api.getAccessToken(authorization, grantType)
        }

        if (response.isSuccessful) {
            val tokenResponse = response.body()
            accessToken = tokenResponse?.access_token
        } else {
            Log.e("SpotifyToken", "Error: ${response.code()}")
        }

        return accessToken  // Trả về token sau khi lấy thành công
    }

}
