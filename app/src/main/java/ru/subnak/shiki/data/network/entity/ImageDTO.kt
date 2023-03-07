package ru.subnak.shiki.data.network.entity

import com.google.gson.annotations.SerializedName

data class ImageDTO(
    @SerializedName("original")
    val original: String,
    @SerializedName("preview")
    val preview: String,
    @SerializedName("x48")
    val x48: String,
    @SerializedName("x96")
    val x96: String
)