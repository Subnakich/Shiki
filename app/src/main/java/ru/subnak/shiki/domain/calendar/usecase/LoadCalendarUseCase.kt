package ru.subnak.shiki.domain.calendar.usecase

import ru.subnak.shiki.domain.calendar.CalendarRepository
import javax.inject.Inject

class LoadCalendarUseCase @Inject constructor(private val repository: CalendarRepository) {
    suspend operator fun invoke() = repository.loadCalendar()
}