package ru.subnak.shiki.domain.calendar

import kotlinx.coroutines.flow.Flow
import ru.subnak.shiki.domain.entity.CalendarModel


interface CalendarRepository {

    fun loadCalendar(): Flow<CalendarModel>
}