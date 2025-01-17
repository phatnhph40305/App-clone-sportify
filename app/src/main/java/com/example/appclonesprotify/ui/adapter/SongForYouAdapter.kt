package com.example.appclonesprotify.ui.adapter

import com.example.appclonesprotify.data.model.Item

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView
import com.example.appclonesprotify.databinding.ViewHolderSongForYouBinding
import com.example.appclonesprotify.R

class SongForYouAdapter(
    private val listItem: List<Item>,
    private val onAddListSong : (item: Item) -> Unit,
    private val onAddFavorite : (item: Item) -> Unit,
    private val onHideSong : (item: Item) -> Unit,
    private val onClickItem :OnClickItem

) : RecyclerView.Adapter<SongForYouAdapter.ViewHolderHome>() {
    inner class ViewHolderHome(private val binding: ViewHolderSongForYouBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Item, position: Int) {
            val listArtist = item.artists
            val nameArtists = StringBuilder().apply {
                item.artists.forEachIndexed() { index, item ->
                    if (index != listArtist.size - 1) {
                        append("${item.name}, ")
                    } else {
                        append(item.name)
                    }
                }
            }

            binding.tvNameArtist.text = nameArtists
            binding.tvNameSong.text = item.name

            binding.layoutPlayMusic.setOnClickListener {
                onClickItem.playMusic( position)
            }

            val btnMore = binding.btnMore
            btnMore.setOnClickListener {
                val popupMenu = PopupMenu(it.context, it)
                popupMenu.inflate(R.menu.menu_select_options)

                popupMenu.setOnMenuItemClickListener { menuItem ->
                    when (menuItem.itemId) {
                        R.id.acAddListSong -> {
                            onAddListSong(item)
                            true
                        }
                        R.id.acAddFavorite -> {
                            onAddFavorite(item)
                            true
                        }
                        R.id.acHideSong -> {
                            onHideSong(item)
                            true
                        }

                        else -> false
                    }
                }
                popupMenu.show()

            }
        }
    }



    interface OnClickItem{
        fun playMusic( position: Int)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderHome {
        val viewHolder =
            ViewHolderSongForYouBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderHome(viewHolder)
    }

    override fun getItemCount(): Int = listItem.size

    override fun onBindViewHolder(holder: ViewHolderHome, position: Int) {
        holder.bind(listItem[position] , position)

    }
}