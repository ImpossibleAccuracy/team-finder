package org.teamfinder.data.entity.game

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Games : IntIdTable("game", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val creatorID: Column<Int> = integer("creatorid").references(id)

    val title: Column<String> = varchar("title", 255)

    val description: Column<String> = text("description")

    val creatorStudioName: Column<String> = varchar("creatorstudioname", 255)

    val mediaCollectionID: Column<Int> =
        integer("mediacollectionid").references(id)

    val validated: Column<Boolean> = bool("validated")

    val validatedBy: Column<Int?> = integer("validatedby").references(id).nullable()
}
