package com.example.appclonesprotify.data.model

data class PlaylistTracksResponse(
    val items: List<TrackItem>
)

data class TrackItem(
    val track: Track
)

data class Track(
    val id: String,
    val name: String,
    val artists: List<Artist>,
    val album: Album
)

data class Artist(
    val id: String,
    val name: String
)

data class Album(
    val id: String,
    val name: String,
    val images: List<Image>
)

data class Image(
    val url: String
)
