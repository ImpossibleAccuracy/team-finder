package org.teamfinder.data.entity.channel.thread

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object ChannelThreads : IntIdTable("channelthread", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val channelID: Column<Int> = integer("channelid").references(org.teamfinder.data.entity.channel.Channels.id)

    val title: Column<String> = varchar("title", 255)

    val roomID: Column<Int> = integer("roomid").references(id)

    val isSecured: Column<Boolean> = bool("issecured")
}
