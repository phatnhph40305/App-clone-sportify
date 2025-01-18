package com.example.appclonesprotify.data.model

import com.google.gson.annotations.SerializedName



data class Artist(
    @SerializedName("external_urls")
    val externalUrls: ArtistExternalUrl,

    val followers: Followers,

    val genres: List<String>,

    val href: String,

    val id: String,

    val images: List<Image>,

    val name: String,

    val popularity: Int,

    val type: String,

    val uri: String,



)

data class ArtistResponse(
    val artists: List<Artist>
)

data class SearchResponse(
    @SerializedName("artists")
    val artists: ArtistSearchResult
)

data class ArtistSearchResult(
    val items: List<Artist>,
    val total: Int,
    val limit: Int,
    val offset: Int
)

data class Followers(
    val href: String?,
    val total: Int
)

data class Image(
    val url: String,
    val height: Int,
    val width: Int
)

data class ArtistExternalUrl(
    val spotify: String
)


