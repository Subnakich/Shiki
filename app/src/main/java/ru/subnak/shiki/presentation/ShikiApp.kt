package ru.subnak.shiki.presentation

import android.app.Application
import ru.subnak.shiki.di.DaggerApplicationComponent

class ShikiApp : Application() {
    val component by lazy {
        DaggerApplicationComponent.factory().create(this)
    }
}