package ru.subnak.shiki.di

import dagger.Module

@Module(
    includes = [
        RetrofitModule::class
    ]
)
interface ApiModule {
}