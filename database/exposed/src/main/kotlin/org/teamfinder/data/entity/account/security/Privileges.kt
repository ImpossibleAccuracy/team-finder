package org.teamfinder.data.entity.account.security

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Privileges : IntIdTable("privilege", "id") {
    val title: Column<String> = varchar("title", 255).uniqueIndex()
}
