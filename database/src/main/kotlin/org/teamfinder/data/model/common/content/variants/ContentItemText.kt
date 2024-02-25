package org.teamfinder.data.model.common.content.variants

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.content.variants.ContentItemsText

class ContentItemText(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ContentItemText>(ContentItemsText)

    val text by ContentItemsText.text
}
