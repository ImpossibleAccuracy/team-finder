package org.teamfinder.data.entity.game.genre

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.game.Games

object GameGenreRef : IdTable<Int>("game_genre") {
    val gameID: Column<Int> = integer("gameid").references(Games.id)

    val genreID: Column<Int> = integer("genreid").references(Genres.id)

    val order: Column<Int> = integer("order")

    override val id: Column<EntityID<Int>>
        get() = gameID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        gameID,
        genreID
    )
}
