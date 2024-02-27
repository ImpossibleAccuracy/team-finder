package org.teamfinder.data.model.common.room

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.room.RoomMembers

class RoomMember(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<RoomMember>(RoomMembers)

    val roomID by RoomMembers.roomID

    val memberID by RoomMembers.memberID

    val createdAt by RoomMembers.createdAt

    val isAdmin by RoomMembers.isAdmin
}
