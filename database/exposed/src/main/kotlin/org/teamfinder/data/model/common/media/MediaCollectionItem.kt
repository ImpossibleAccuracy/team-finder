package org.teamfinder.data.model.common.media

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.media.MediaCollectionItems
import org.teamfinder.data.model.common.file.LocalFile

class MediaCollectionItem(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<MediaCollectionItem>(MediaCollectionItems)

    val collection by MediaCollection referencedOn MediaCollectionItems.mediaCollectionID

    val order by MediaCollectionItems.order

    val internal by LocalFile optionalReferencedOn MediaCollectionItems.internalID

    val externalPath by MediaCollectionItems.externalPath

    val externalTypeID by MediaItemExternalType optionalReferencedOn MediaCollectionItems.externalTypeID
}
