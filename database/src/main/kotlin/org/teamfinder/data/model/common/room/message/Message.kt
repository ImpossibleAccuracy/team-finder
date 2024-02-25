package org.teamfinder.data.model.common.room.message

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.room.message.Messages

class Message(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Message>(Messages)

    val createdAt by Messages.createdAt

    val roomID by Messages.roomID

    val creatorID by Messages.creatorID

    val parentID by Messages.parentID
}
