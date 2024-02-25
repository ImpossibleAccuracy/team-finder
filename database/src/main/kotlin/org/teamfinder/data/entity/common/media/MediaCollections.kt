package org.teamfinder.data.entity.common.media

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object MediaCollections : IntIdTable("mediacollection", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val creatorID: Column<Int> = integer("creatorid").references(id)
}
