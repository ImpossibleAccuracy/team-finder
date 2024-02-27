package org.teamfinder.data.entity.common.content.variants

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.common.content.ContentItems
import org.teamfinder.data.entity.common.media.MediaCollections

object ContentItemsMedia : IdTable<Int>("contentitemmedia") {
    override val id: Column<EntityID<Int>> = integer("id").references(ContentItems.id).entityId()

    val mediaCollectionID: Column<Int> =
        integer("mediacollectionid").references(MediaCollections.id)
}