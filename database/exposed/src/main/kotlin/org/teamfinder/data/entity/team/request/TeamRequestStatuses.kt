package org.teamfinder.data.entity.team.request

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object TeamRequestStatuses : IntIdTable("teamrequeststatus", "id") {
    val title: Column<String> = varchar(
        "title",
        255
    ).uniqueIndex()
}
