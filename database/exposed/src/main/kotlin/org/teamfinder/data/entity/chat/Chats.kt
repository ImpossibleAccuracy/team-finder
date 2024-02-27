package org.teamfinder.data.entity.chat

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.common.file.LocalFiles
import org.teamfinder.data.entity.common.room.Rooms

object Chats : IdTable<Int>("chat") {
    override val id: Column<EntityID<Int>> = integer("id").references(Rooms.id).entityId()

    val title: Column<String> = varchar("title", 255)

    val description: Column<String?> = text("description").nullable()

    val isGroup: Column<Boolean> = bool("isgroup")

    val logoID: Column<Int?> = integer("logoid").references(LocalFiles.id).nullable()
}
