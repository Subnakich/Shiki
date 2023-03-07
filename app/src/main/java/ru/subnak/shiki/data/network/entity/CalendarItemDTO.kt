package ru.subnak.shiki.data.network.entity

import com.google.gson.annotations.SerializedName

data class CalendarItemDTO(
    @SerializedName("anime")
    val anime: AnimeDTO,
    @SerializedName("duration")
    val duration: String?,
    @SerializedName("next_episode")
    val nextEpisode: Int,
    @SerializedName("next_episode_at")
    val nextEpisodeAt: String?
)