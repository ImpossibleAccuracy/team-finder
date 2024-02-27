package org.teamfinder.data.model.common.media

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.media.MediaCollectionItems
import org.teamfinder.data.entity.common.media.MediaCollections

class MediaCollection(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<MediaCollection>(MediaCollections)

    val createdAt by MediaCollections.createdAt

    val creator by MediaCollections.creatorID

    val items by MediaCollectionItem referrersOn MediaCollectionItems.mediaCollectionID
}
