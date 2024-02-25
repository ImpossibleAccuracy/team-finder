package org.teamfinder.data.entity.common.content

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object ContentItemsType : IntIdTable("contentitemtype", "id") {
    val title: Column<String> = varchar(
        "title",
        255
    ).uniqueIndex()
}
