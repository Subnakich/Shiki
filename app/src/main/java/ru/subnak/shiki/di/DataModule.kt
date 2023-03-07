package ru.subnak.shiki.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import ru.subnak.shiki.data.network.ApiFactory
import ru.subnak.shiki.data.network.apiservice.ApiAuth
import ru.subnak.shiki.data.network.impl.AuthRepositoryImpl
import ru.subnak.shiki.data.network.impl.CalendarRepositoryImpl
import ru.subnak.shiki.domain.auth.AuthRepository
import ru.subnak.shiki.domain.calendar.CalendarRepository

@Module
interface DataModule {

    @Binds
    fun bindCalendarRepository(impl: CalendarRepositoryImpl): CalendarRepository

    @Binds
    fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository
}