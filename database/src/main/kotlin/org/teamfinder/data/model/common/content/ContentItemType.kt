package org.teamfinder.data.model.common.content

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.content.ContentItemsType

class ContentItemType(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ContentItemType>(ContentItemsType)

    val title by ContentItemsType.title
}
