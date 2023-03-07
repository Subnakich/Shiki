package ru.subnak.shiki.domain.entity

data class Anime(
    val airedOn: String?,
    val episodes: Int,
    val episodesAired: Int,
    val id: Int,
    val image: Image,
    val kind: String?,
    val name: String,
    val releasedOn: String?,
    val russian: String?,
    val score: String,
    val status: String?,
    val url: String
)