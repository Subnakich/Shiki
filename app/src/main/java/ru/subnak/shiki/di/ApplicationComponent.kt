package ru.subnak.shiki.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import ru.subnak.shiki.presentation.fragment.calendar.CalendarFragment
import ru.subnak.shiki.presentation.fragment.search.SearchFragment
import ru.subnak.shiki.presentation.fragment.userprofile.UserProfileFragment
import ru.subnak.shiki.presentation.fragment.userrates.UserRatesFragment

@Component(
    modules = [
        DataModule::class,
        ViewModelModule::class
    ]
)
interface ApplicationComponent {

    fun inject(fragment: CalendarFragment)
    fun inject(fragment: SearchFragment)
    fun inject(fragment: UserRatesFragment)
    fun inject(fragment: UserProfileFragment)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance application: Application
        ): ApplicationComponent
    }
}