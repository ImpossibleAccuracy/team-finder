package org.teamfinder.data.model.common.content.variants

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.content.variants.ContentItemsInvite

class ContentItemInvite(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ContentItemInvite>(ContentItemsInvite)

    val inviteID by ContentItemsInvite.inviteID
}
