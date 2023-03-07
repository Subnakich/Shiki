package ru.subnak.shiki.data.network.apiservice

import retrofit2.http.GET
import retrofit2.http.Headers
import ru.subnak.shiki.data.network.entity.CalendarItemDTO

interface ApiCalendar {

    @GET("/api/calendar")
    suspend fun getCalendar(): List<CalendarItemDTO>
}