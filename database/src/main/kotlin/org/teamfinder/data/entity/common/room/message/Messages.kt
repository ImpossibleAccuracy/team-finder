package org.teamfinder.data.entity.common.room.message

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Messages : IntIdTable("message", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val roomID: Column<Int> = integer("roomid").references(id)

    val creatorID: Column<Int> = integer("creatorid").references(id)

    val parentID: Column<Int?> = integer("parentid").references(id).nullable()
}
