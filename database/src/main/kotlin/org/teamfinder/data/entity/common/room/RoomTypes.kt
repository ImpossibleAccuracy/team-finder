package org.teamfinder.data.entity.common.room

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object RoomTypes : IntIdTable("roomtype", "id") {
    val title: Column<String> = varchar("title", 255).uniqueIndex()
}
