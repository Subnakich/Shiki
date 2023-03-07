package ru.subnak.shiki.data.mapper

import ru.subnak.shiki.data.network.entity.AnimeDTO
import ru.subnak.shiki.data.network.entity.CalendarItemDTO
import ru.subnak.shiki.data.network.entity.ImageDTO
import ru.subnak.shiki.domain.entity.Anime
import ru.subnak.shiki.domain.entity.CalendarAnimeItem
import ru.subnak.shiki.domain.entity.CalendarModel
import ru.subnak.shiki.domain.entity.Image
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import javax.inject.Inject

class CalendarMapper @Inject constructor() {

    fun dtoToCalendarList(dto: List<CalendarItemDTO>): List<CalendarModel> {
        val list = mutableListOf<CalendarModel>()
        val map = dto.groupBy {
            val newCalendarItem = dtoToCalendarItem(it)
            newCalendarItem.nextEpisodeAt?.toLocalDate()
        }
        map.forEach {
            list.add(
                CalendarModel(it.key, dtoToCalendar(it.value))
            )
        }
        return list
    }

    fun dtoToCalendar(dto: List<CalendarItemDTO>): List<CalendarAnimeItem> {
        val list = mutableListOf<CalendarAnimeItem>()
        dto.forEach {
            list.add(
                dtoToCalendarItem(it)
            )
        }
        return list
    }

    fun dtoToCalendarItem(dto: CalendarItemDTO) = CalendarAnimeItem(
        anime = dtoToAnime(dto.anime),
        duration = dto.duration,
        nextEpisode = dto.nextEpisode,
        nextEpisodeAt = nextEpisodeAtToDateTime(dto.nextEpisodeAt)
    )


    fun dtoToAnime(dto: AnimeDTO): Anime = Anime(
        airedOn = dto.airedOn,
        episodes = dto.episodes,
        episodesAired = dto.episodesAired,
        id = dto.id,
        image = dtoToImage(dto.image),
        kind = dto.kind,
        name = dto.name,
        releasedOn = dto.releasedOn,
        russian = dto.russian,
        score = dto.score,
        status = dto.status,
        url = dto.url
    )

    fun dtoToImage(dto: ImageDTO): Image = Image(
        original = dto.original,
        x48 = dto.x48,
        x96 = dto.x96,
        preview = dto.preview
    )

    fun nextEpisodeAtToDateTime(dateString: String?): LocalDateTime {
        val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
        return LocalDateTime.parse(dateString, formatter)
    }


}