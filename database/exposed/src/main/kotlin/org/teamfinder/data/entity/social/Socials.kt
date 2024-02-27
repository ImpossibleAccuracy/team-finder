package org.teamfinder.data.entity.social

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Socials : IntIdTable("social", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val title: Column<String> = varchar("title", 255).uniqueIndex()

    val logoID: Column<Int?> = integer("logoid").references(id).nullable()
}
