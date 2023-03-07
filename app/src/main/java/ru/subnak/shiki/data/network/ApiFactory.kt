package ru.subnak.shiki.data.network

import org.reactivestreams.FlowAdapters
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import ru.subnak.shiki.data.network.apiservice.ApiAuth
import ru.subnak.shiki.data.network.apiservice.ApiCalendar

object ApiFactory {
    const val BASE_URL = "https://shikimori.one/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiCalendar: ApiCalendar = retrofit.create(ApiCalendar::class.java)
    val apiAuth: ApiAuth = retrofit.create(ApiAuth::class.java)
}