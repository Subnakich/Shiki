package ru.subnak.shiki.presentation.adapter.calendar

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import ru.subnak.shiki.databinding.ItemCalendarAnimeBinding
import ru.subnak.shiki.domain.entity.CalendarAnimeItem


class CalendarAnimeItemAdapter : ListAdapter<CalendarAnimeItem, CalendarAnimeItemViewHolder>(
    CalendarAnimeItemDiffCallBack
) {

    var onCalendarAnimeItemClickListener: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarAnimeItemViewHolder {
        val binding = ItemCalendarAnimeBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CalendarAnimeItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CalendarAnimeItemViewHolder, position: Int) {
        val animeItem = getItem(position)

        holder.itemView.setOnClickListener {
            onCalendarAnimeItemClickListener?.invoke(animeItem.anime.id)
        }

        with(holder.binding) {

            val progressDrawable = getCircularProgressDrawable(holder.itemView.context)

            imageviewAnime.contentDescription =
                animeItem.anime.russian // TODO: форматирование строки

            Glide.with(this.root)
                .load("https://shikimori.one" + animeItem.anime.image.preview)
                .error(progressDrawable)
                .placeholder(progressDrawable)
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .transition(DrawableTransitionOptions.withCrossFade())
                .centerInside()
                .into(this.imageviewAnime)

            textviewAnime.text = animeItem.anime.russian
            textviewAnimeEp.text = animeItem.nextEpisode.toString()
            textviewAnimeTime.text = animeItem.nextEpisodeAt.toString()
        }
    }

    private fun getCircularProgressDrawable(context: Context): CircularProgressDrawable {
        val circularProgress = CircularProgressDrawable(context)
        circularProgress.strokeWidth = 3f
        circularProgress.centerRadius = 30f
        circularProgress.start()
        return circularProgress
    }

//    private fun posToString(position: Int, context: Context): String {
//        return String.format(
//            context.getString(R.string.nodes_number),
//            position
//        )
//    }
}