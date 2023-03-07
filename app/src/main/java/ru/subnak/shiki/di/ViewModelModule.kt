package ru.subnak.shiki.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.subnak.shiki.presentation.fragment.calendar.CalendarViewModel
import ru.subnak.shiki.presentation.fragment.search.SearchViewModel
import ru.subnak.shiki.presentation.fragment.userprofile.UserProfileViewModel
import ru.subnak.shiki.presentation.fragment.userrates.UserRatesViewModel

@Module
interface ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CalendarViewModel::class)
    fun bindCalendarViewModel(viewModel: CalendarViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserProfileViewModel::class)
    fun bindUserProfileViewModel(viewModel: UserProfileViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(UserRatesViewModel::class)
    fun bindUserRatesViewModel(viewModel: UserRatesViewModel): ViewModel
}