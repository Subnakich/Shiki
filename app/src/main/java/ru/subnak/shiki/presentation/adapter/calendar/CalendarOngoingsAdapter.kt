package ru.subnak.shiki.presentation.adapter.calendar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.ListAdapter
import ru.subnak.shiki.databinding.ItemCalendarBinding

import ru.subnak.shiki.domain.entity.CalendarModel


class CalendarOngoingsAdapter : ListAdapter<CalendarModel, CalendarOngoingsViewHolder>(
    CalendarOngoingsDiffCallBack
) {

    var onCalendarOngoingsClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarOngoingsViewHolder {
        val binding = ItemCalendarBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CalendarOngoingsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarOngoingsViewHolder, position: Int) {
        val list = getItem(position)
        val adapterAnimeList = CalendarAnimeItemAdapter()

        adapterAnimeList.onCalendarAnimeItemClickListener = { animeId ->
            onCalendarOngoingsClickListener?.invoke(animeId)
        }


        adapterAnimeList.submitList(list.calendarAnimeItemList)

        with(holder.binding) {
            val layoutManagerAnimeList =
                LinearLayoutManager(
                    holder.itemView.context,
                    LinearLayoutManager.HORIZONTAL,
                    false
                )
            recyclerView.layoutManager = layoutManagerAnimeList
            recyclerView.adapter = adapterAnimeList
            textviewDate.text = list.date.toString()
        }
    }
}