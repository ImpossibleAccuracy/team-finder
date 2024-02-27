package org.teamfinder.data.entity.account.security

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Roles : IntIdTable("role", "id") {
    val title: Column<String> = varchar("title", 255).uniqueIndex()
}
