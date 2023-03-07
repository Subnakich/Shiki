package ru.subnak.shiki.domain.entity

import java.time.LocalDateTime


data class CalendarAnimeItem(
    val anime: Anime,
    val duration: String?,
    val nextEpisode: Int,
    val nextEpisodeAt: LocalDateTime?
)
