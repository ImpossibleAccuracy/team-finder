package org.teamfinder.data.model.common.room

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.room.RoomTypes

class RoomType(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoomType>(RoomTypes)

    val title by RoomTypes.title
}
