package org.teamfinder.data.entity.channel.invite

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object ChannelInvites : IntIdTable("channelinvite", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val channelID: Column<Int> = integer("channelid").references(id)

    val accountID: Column<Int> = integer("accountid").references(id)

    val expiredAt: Column<LocalDateTime?> = datetime("expiredat").nullable()
}
