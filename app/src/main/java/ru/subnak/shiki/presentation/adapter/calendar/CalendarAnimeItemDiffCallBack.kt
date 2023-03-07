package ru.subnak.shiki.presentation.adapter.calendar

import androidx.recyclerview.widget.DiffUtil
import ru.subnak.shiki.domain.entity.CalendarAnimeItem

object CalendarAnimeItemDiffCallBack : DiffUtil.ItemCallback<CalendarAnimeItem>() {
    override fun areItemsTheSame(oldItem: CalendarAnimeItem, newItem: CalendarAnimeItem): Boolean {
        return oldItem.anime.id == newItem.anime.id
    }

    override fun areContentsTheSame(
        oldItem: CalendarAnimeItem,
        newItem: CalendarAnimeItem
    ): Boolean {
        return oldItem == newItem
    }
}