package org.teamfinder.data.model.game.genre

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.game.genre.Genres

class Genre(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Genre>(Genres)

    val title by Genres.title
}
