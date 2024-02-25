package org.teamfinder.data.model.common.room

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.room.Rooms

class Room(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Room>(Rooms)

    val createdAt by Rooms.createdAt

    val typeID by Rooms.typeID

    val creatorID by Rooms.creatorID
}
