package com.example.appclonesprotify.data.model

import com.google.gson.annotations.SerializedName

data class AlbumTracks(
     val href: String,
     val limit: Float,
     val next: String,
     val offset: Int,
     val previous: String,
     val total: Int,
     val items: List<Item>
){
    constructor() : this("", 0f, "", 0, "", 0, emptyList())
}



data class Item(
     val artists: List<Artist>,

//    @SerializedName("available_markets")
//     val availableMarkets: List<String>,

    @SerializedName("disc_number")
     val discNumber: Int,


    @SerializedName("duration_ms")
     val durationMs: Int,

     val explicit: Boolean,

    @SerializedName("external_urls")
     val externalUrls: ExternalUrl,

     val href: String,

     val id: String,

    @SerializedName("is_playable")
     val isPlayable: Boolean,

    @SerializedName("linked_from")
     val linkedFrom: Linked,

     val restrictions: Restriction,

     val name: String,

    @SerializedName("preview_url")
     val previewUrl: String,

    @SerializedName("track_number")
     val trackNumber: Int,

     val type: String,

     val uri: String,

    @SerializedName("is_local")
     val isLocal: Boolean
)

data class Restriction(
     val reason: String
)

data class Linked(

    @SerializedName("external_urls")
     val externalUrls: ExternalUrl,

     val href: String,

     val id: String,

     val type: String,

     val uri: String

)

data class ExternalUrl(
     val spotify: String
)


data class Artist(
    @SerializedName("external_urls")
     val externalUrls: ExternalUrl,

     val href: String,

     val id: String,

     val name: String,

     val type: String,

     val uri: String,
)
