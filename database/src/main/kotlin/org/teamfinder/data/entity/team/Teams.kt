package org.teamfinder.data.entity.team

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Teams : IntIdTable("team", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val creatorID: Column<Int> = integer("creatorid").references(id)

    val title: Column<String> = varchar("title", 255)

    val description: Column<String> = text("description")

    val typeID: Column<Int> = integer("typeid").references(id)

    val statusID: Column<Int> = integer("statusid").references(id)

    val totalPersonAmount: Column<Int?> = integer("totalpersonamount").nullable()
}
