package org.teamfinder.data.entity.game.genre

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Genres : IntIdTable("genre", "id") {
    val title: Column<String> = varchar("title", 255).uniqueIndex()
}
