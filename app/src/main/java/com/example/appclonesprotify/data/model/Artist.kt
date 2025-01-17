package com.example.appclonesprotify.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Artist(
    @SerializedName("external_urls")
     val externalUrls: ExternalUrl,

     val href: String,

     val id: String,

     val name: String,

     val type: String,

     val uri: String,
): Serializable