package org.teamfinder.data.entity.channel.meta

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.channel.Channels
import org.teamfinder.data.entity.social.Socials

object ChannelSocials : IdTable<Int>("channel_social") {
    val channelID: Column<Int> = integer("channelid").references(Channels.id)

    val socialID: Column<Int> = integer("socialid").references(Socials.id)

    val data: Column<String> = varchar("value", 255)

    override val id: Column<EntityID<Int>>
        get() = channelID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        channelID,
        socialID
    )
}
