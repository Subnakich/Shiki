package ru.subnak.shiki.domain.entity

import java.time.LocalDate

data class CalendarModel(
    val date: LocalDate?,
    val calendarAnimeItemList: List<CalendarAnimeItem>
)
