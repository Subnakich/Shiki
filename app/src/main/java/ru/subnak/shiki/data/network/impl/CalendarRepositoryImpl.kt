package ru.subnak.shiki.data.network.impl

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import ru.subnak.shiki.data.mapper.CalendarMapper
import ru.subnak.shiki.data.network.ApiFactory
import ru.subnak.shiki.domain.calendar.CalendarRepository
import ru.subnak.shiki.domain.entity.CalendarModel
import javax.inject.Inject

class CalendarRepositoryImpl @Inject constructor(
    private val mapper: CalendarMapper
) : CalendarRepository {

    private val apiService = ApiFactory.apiCalendar

    override fun loadCalendar(): Flow<CalendarModel> {
        return flow {
            val calendarDTO = mapper.dtoToCalendarList(apiService.getCalendar())
            for (calendarItem in calendarDTO) {
                emit(calendarItem)
            }
        }
            .retry(RETRY_ATTEMPTS_COUNT)
            .flowOn(Dispatchers.IO)
            .catch { throwable ->
                Log.e(TAG, "Failed to load calendar", throwable)

            }
    }

    companion object {
        private const val TAG = "CalendarRepositoryImpl"
        private const val RETRY_ATTEMPTS_COUNT = 3L
    }
}