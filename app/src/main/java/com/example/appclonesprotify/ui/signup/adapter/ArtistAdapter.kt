package com.example.appclonesprotify.ui.signup.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appclonesprotify.R
import com.example.appclonesprotify.data.model.Artist

class ArtistAdapter(private val artists: List<Artist>) :
    RecyclerView.Adapter<ArtistAdapter.ArtistViewHolder>() {

    class ArtistViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val artistImageView1: ImageView = itemView.findViewById(R.id.artistImageView1)
        val artistNameTextView1: TextView = itemView.findViewById(R.id.artistNameTextView1)
        val artistImageView2: ImageView = itemView.findViewById(R.id.artistImageView2)
        val artistNameTextView2: TextView = itemView.findViewById(R.id.artistNameTextView2)
        val artistImageView3: ImageView = itemView.findViewById(R.id.artistImageView3)
        val artistNameTextView3: TextView = itemView.findViewById(R.id.artistNameTextView3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArtistViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artist, parent, false)
        return ArtistViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ArtistViewHolder, position: Int) {
        val index = position * 3
        val artist1 = artists.getOrNull(index)
        val artist2 = artists.getOrNull(index + 1)
        val artist3 = artists.getOrNull(index + 2)

        Log.d("ArtistAdapter", "Binding data for position: $position")
        Log.d("ArtistAdapter", "Artist 1: ${artist1?.name}, Image: ${artist1?.images?.firstOrNull()?.url}")
        Log.d("ArtistAdapter", "Artist 2: ${artist2?.name}, Image: ${artist2?.images?.firstOrNull()?.url}")
        Log.d("ArtistAdapter", "Artist 3: ${artist3?.name}, Image: ${artist3?.images?.firstOrNull()?.url}")

        artist1?.let {
            holder.artistNameTextView1.text = it.name
            Glide.with(holder.itemView.context)
                .load(it.images.firstOrNull()?.url)
                .placeholder(R.drawable.default_artist_image)
                .into(holder.artistImageView1)
        }


        artist2?.let {
            holder.artistNameTextView2.text = it.name
            Glide.with(holder.itemView.context)
                .load(it.images.firstOrNull()?.url)
                .placeholder(R.drawable.default_artist_image)
                .into(holder.artistImageView2)
        }


        artist3?.let {
            holder.artistNameTextView3.text = it.name
            Glide.with(holder.itemView.context)
                .load(it.images.firstOrNull()?.url)
                .placeholder(R.drawable.default_artist_image)
                .into(holder.artistImageView3)
        }
    }

    override fun getItemCount(): Int = (artists.size + 2) / 3
}
