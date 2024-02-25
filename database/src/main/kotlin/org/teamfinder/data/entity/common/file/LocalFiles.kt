package org.teamfinder.data.entity.common.file

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object LocalFiles : IntIdTable("file", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val type: Column<Int> = integer("type").references(id)

    val path: Column<String> = varchar("path", 255).uniqueIndex()

    val hash: Column<String> = varchar("hash", 255).uniqueIndex()
}
