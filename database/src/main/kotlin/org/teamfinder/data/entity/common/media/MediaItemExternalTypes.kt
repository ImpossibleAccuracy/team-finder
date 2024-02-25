package org.teamfinder.data.entity.common.media

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object MediaItemExternalTypes : IntIdTable("mediaitemexternaltype", "id") {
    val title: Column<String> = varchar(
        "title",
        255
    ).uniqueIndex()
}
