package com.example.appclonesprotify.ui.signup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appclonesprotify.R

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
        val artist1 = artists[position * 3]
        val artist2 = artists[position * 3 + 1]
        val artist3 = artists[position * 3 + 2]

        holder.artistNameTextView1.text = artist1.name

        holder.artistNameTextView2.text = artist2.name


        holder.artistNameTextView3.text = artist3.name

    }

    override fun getItemCount(): Int = artists.size / 3
    }
