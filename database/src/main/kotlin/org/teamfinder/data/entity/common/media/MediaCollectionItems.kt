package org.teamfinder.data.entity.common.media

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object MediaCollectionItems : IntIdTable("mediacollectionitem", "id") {
    val mediaCollectionID: Column<Int> =
        integer("mediacollectionid").references(id)

    val order: Column<Int> = integer("order")

    val internalID: Column<Int?> = integer("internalid").references(id).nullable()

    val externalPath: Column<String?> = varchar("externalpath", 255).nullable()

    val externalTypeID: Column<Int?> =
        integer("externaltypeid").references(id).nullable()
}
