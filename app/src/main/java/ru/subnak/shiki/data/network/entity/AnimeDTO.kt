package ru.subnak.shiki.data.network.entity

import com.google.gson.annotations.SerializedName

data class AnimeDTO(
    @SerializedName("aired_on")
    val airedOn: String?,
    @SerializedName("episodes")
    val episodes: Int,
    @SerializedName("episodes_aired")
    val episodesAired: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: ImageDTO,
    @SerializedName("kind")
    val kind: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("released_on")
    val releasedOn: String?,
    @SerializedName("russian")
    val russian: String?,
    @SerializedName("score")
    val score: String,
    @SerializedName("status")
    val status: String?,
    @SerializedName("url")
    val url: String
)