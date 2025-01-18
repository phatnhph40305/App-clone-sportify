package com.example.appclonesprotify.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

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
    val isLocal: Boolean,

    val favorite: Boolean
) : Serializable