package ru.subnak.shiki.presentation.adapter.calendar

import androidx.recyclerview.widget.DiffUtil
import ru.subnak.shiki.domain.entity.CalendarModel

object CalendarOngoingsDiffCallBack : DiffUtil.ItemCallback<CalendarModel>() {
    override fun areItemsTheSame(oldItem: CalendarModel, newItem: CalendarModel): Boolean {
        return oldItem.date == newItem.date
    }

    override fun areContentsTheSame(oldItem: CalendarModel, newItem: CalendarModel): Boolean {
        return oldItem == newItem
    }
}