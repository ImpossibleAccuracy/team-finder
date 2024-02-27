package org.teamfinder.data.model.common.content

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.content.ContentItems

class ContentItem(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ContentItem>(ContentItems)

    val subjectTypeID by ContentItems.subjectTypeID
}
