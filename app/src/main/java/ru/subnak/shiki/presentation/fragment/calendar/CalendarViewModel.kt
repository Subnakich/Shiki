package ru.subnak.shiki.presentation.fragment.calendar

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.subnak.shiki.domain.entity.CalendarModel
import ru.subnak.shiki.domain.calendar.usecase.LoadCalendarUseCase
import javax.inject.Inject

class CalendarViewModel @Inject constructor(
    private val loadCalendarUseCase: LoadCalendarUseCase
) : ViewModel() {

    private val _result = MutableLiveData<List<CalendarModel>>(emptyList())
    val result: LiveData<List<CalendarModel>>
        get() = _result

    init {
        viewModelScope.launch {
            loadCalendarUseCase.invoke()
                .collect { calendarItem ->
                    val currentList = _result.value.orEmpty().toMutableList()
                    currentList.add(calendarItem)
                    _result.value = currentList
                    Log.d(TAG, _result.value.toString())
                }
        }
    }

    companion object {
        private const val TAG = "CalendarViewModel"

    }
}