package org.teamfinder.data.entity.common.room

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Rooms : IntIdTable("room", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val typeID: Column<Int> = integer("typeid").references(id)

    val creatorID: Column<Int> = integer("creatorid").references(id)
}
