package org.teamfinder.data.model.common.media

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.media.MediaItemExternalTypes

class MediaItemExternalType(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<MediaItemExternalType>(MediaItemExternalTypes)

    val title by MediaItemExternalTypes.title
}