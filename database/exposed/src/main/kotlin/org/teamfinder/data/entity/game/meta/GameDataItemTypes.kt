package org.teamfinder.data.entity.game.meta

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object GameDataItemTypes : IntIdTable("gamedatatype", "id") {
    val title: Column<String> = varchar(
        "title",
        255
    ).uniqueIndex()
}
