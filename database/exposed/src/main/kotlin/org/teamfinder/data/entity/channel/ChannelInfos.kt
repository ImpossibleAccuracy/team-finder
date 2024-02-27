package org.teamfinder.data.entity.channel

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.common.file.LocalFiles

object ChannelInfos : IdTable<Int>("channelinfo") {
    override val id: Column<EntityID<Int>> =
        integer("id").references(Channels.id).entityId()

    val description: Column<String> = text("description")

    val logoID: Column<Int> = integer("logoid").references(LocalFiles.id)

    val backgroundID: Column<Int> = integer("backgroundid").references(LocalFiles.id)
}
