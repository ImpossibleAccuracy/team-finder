package org.teamfinder.data.entity.account.data

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object AccountRelationshipTypes : IntIdTable("accountrelationshiptype", "id") {
    val title: Column<String> = varchar(
        "title",
        255
    ).uniqueIndex()
}
