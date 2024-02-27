package org.teamfinder.data.entity.common.file

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object LocalFileTypes : IntIdTable("filetype", "id") {
    val title: Column<String> = varchar("title", 255).uniqueIndex()
}