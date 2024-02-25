package org.teamfinder.data.model.chat

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.chat.Chats
import org.teamfinder.data.model.common.file.LocalFile
import org.teamfinder.data.model.common.room.Room

class Chat(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Chat>(Chats)

    val room by Room referencedOn Chats.id

    val title by Chats.title

    val description by Chats.description

    val isGroup by Chats.isGroup

    val logo by LocalFile optionalReferencedOn Chats.logoID
}
