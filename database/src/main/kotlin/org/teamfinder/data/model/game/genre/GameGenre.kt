package org.teamfinder.data.model.game.genre

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.game.genre.GameGenreRef
import org.teamfinder.data.model.game.Game

class GameGenre(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<GameGenre>(GameGenreRef)

    val game by Game referencedOn GameGenreRef.gameID

    val genre by Genre referencedOn GameGenreRef.genreID

    val order by GameGenreRef.order
}
