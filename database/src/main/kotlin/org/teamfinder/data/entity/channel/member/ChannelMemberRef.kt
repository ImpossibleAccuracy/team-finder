package org.teamfinder.data.entity.channel.member

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import org.teamfinder.data.entity.account.Accounts
import org.teamfinder.data.entity.channel.Channels

object ChannelMemberRef : IdTable<Int>("channelmember") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val channelID: Column<Int> = integer("channelid").references(Channels.id)

    val accountID: Column<Int> = integer("accountid").references(Accounts.id)

    val roleID: Column<Int?> =
        integer("roleid").references(ChannelMemberRoles.id).nullable()

    override val id: Column<EntityID<Int>>
        get() = channelID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        channelID,
        accountID
    )
}
