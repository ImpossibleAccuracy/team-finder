package org.teamfinder.data.entity.common.content.variants

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.common.content.ContentItems

object ContentItemsText : IdTable<Int>("contentitemtext") {
    override val id: Column<EntityID<Int>> = integer("id").references(ContentItems.id).entityId()

    val text: Column<String> = text("text")
}
