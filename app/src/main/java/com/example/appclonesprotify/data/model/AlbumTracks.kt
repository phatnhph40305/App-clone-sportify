package com.example.appclonesprotify.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class AlbumTracks(
     val href: String,
     val limit: Int,
     val next: String,
     val offset: Int,
     val previous: String,
     val total: Int,
     val items: List<Item>
) : Serializable





data class Restriction(
     val reason: String
): Serializable

data class Linked(

    @SerializedName("external_urls")
     val externalUrls: ExternalUrl,

     val href: String,

     val id: String,

     val type: String,

     val uri: String

) : Serializable

data class ExternalUrl(
     val spotify: String
): Serializable



