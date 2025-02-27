package com.example.appclonesprotify.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appclonesprotify.data.model.AlbumTracks
import com.example.appclonesprotify.databinding.ViewHolderRecentlyPlayedBinding

class AlbumsAdapter(val data: List<AlbumTracks>) : RecyclerView.Adapter<AlbumsAdapter.AlbumsViewHolder>() {
   inner class AlbumsViewHolder(private val binding: ViewHolderRecentlyPlayedBinding ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(albumTracks: AlbumTracks){

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumsViewHolder {
        val viewHolderBinding = ViewHolderRecentlyPlayedBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return AlbumsViewHolder(viewHolderBinding)
    }

    override fun getItemCount(): Int =data.size

    override fun onBindViewHolder(holder: AlbumsViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}



