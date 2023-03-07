package ru.subnak.shiki.domain.entity

data class Image(
    val original: String,
    val preview: String,
    val x48: String,
    val x96: String
)