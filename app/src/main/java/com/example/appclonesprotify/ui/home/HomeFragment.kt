package com.example.appclonesprotify.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appclonesprotify.databinding.FragmentHomeBinding
import com.example.appclonesprotify.ui.viewmodel.SpotifyAlbumTracksViewModel
import com.example.appclonesprotify.ui.adapter.SongForYouAdapter
import com.example.appclonesprotify.data.model.Item



class HomeFragment : Fragment() {
    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val recyclerView = binding.recyclerViewSongForYou
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val viewModel =
            ViewModelProvider(requireActivity())[SpotifyAlbumTracksViewModel::class.java]

        viewModel.tracks.observe(viewLifecycleOwner) { tracks ->
            val adapter = tracks?.let {
                SongForYouAdapter(it.items,
                    onAddListSong = {},
                    onAddFavorite = {},
                    onHideSong = {}
                    , object : SongForYouAdapter.OnClickItem{
                        override fun playMusic(item: Item) {
                            Toast.makeText(requireContext(), item.name , Toast.LENGTH_SHORT).show()
                        }

                    }
                )
            }

            recyclerView.adapter = adapter

        }

        return binding.root
    }




}