package com.example.appclonesprotify.ui.signup

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appclonesprotify.R
import com.example.appclonesprotify.data.model.Artist
import com.example.appclonesprotify.data.source.remote.RetrofitInstance
import com.example.appclonesprotify.ui.signup.adapter.ArtistAdapter
import com.example.appclonesprotify.utils.token.AccessToken
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ChooseArtists : AppCompatActivity() {
    private lateinit var artistAdapter: ArtistAdapter
    private val artists = mutableListOf<Artist>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_artist)

        val recyclerView: RecyclerView = findViewById(R.id.artistsRecyclerView)
        val searchEditText: EditText = findViewById(R.id.searchEditText)

        artistAdapter = ArtistAdapter(artists)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = artistAdapter


        fetchArtists()

        searchEditText.addTextChangedListener {
            val query = it.toString().trim()
            if (query.isNotEmpty()) {
                fetchArtists(query)
            }
        }
    }

    private fun fetchArtists(query: String = "a") {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val token = AccessToken.getAccessToken()
                if (token.isNullOrEmpty()) {
                    Log.e("ChooseArtists", "Failed to retrieve access token")
                    return@launch
                }

                val authHeader = "Bearer $token"
                val response = RetrofitInstance.retrofit.searchArtists(authHeader, query)

                if (response.isSuccessful) {
                    val searchResponse = response.body()
                    Log.d("ChooseArtists", "Response: $searchResponse")
                    val fetchedArtists = searchResponse?.artists?.items

                    if (!fetchedArtists.isNullOrEmpty()) {
                        Log.d("ChooseArtists", "Fetched Artists: $fetchedArtists")
                        Log.d("ChooseArtists", "Artists List Size: ${artists.size}")
                        for (artist in artists) {
                            Log.d("ChooseArtists", "Artist Name: ${artist.name}, Image: ${artist.images.firstOrNull()?.url}")
                        }

                        withContext(Dispatchers.Main) {
                            artists.clear()
                            artists.addAll(fetchedArtists)
                            artistAdapter.notifyDataSetChanged()
                        }
                    }
                } else {
                    Log.e("ChooseArtists", "Error fetching artists: ${response.code()} - ${response.message()}")
                }
            } catch (e: Exception) {
                Log.e("ChooseArtists", "Exception fetching artists", e)
            }
        }
    }
}
