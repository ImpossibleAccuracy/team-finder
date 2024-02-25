package org.teamfinder.data.entity.team.meta

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object TeamTypes : IntIdTable("teamtype", "id") {
    val title: Column<String> = varchar("title", 255).uniqueIndex()
}
