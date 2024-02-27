package org.teamfinder.data.entity.channel.meta

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.teamfinder.data.entity.channel.Channels
import org.teamfinder.data.entity.game.Games

object ChannelGameRef : Table("channel_game") {
    val channelID: Column<Int> = integer("channelid").references(Channels.id)

    val gameID: Column<Int> = integer("gameid").references(Games.id)

    override val primaryKey: PrimaryKey = PrimaryKey(
        channelID,
        gameID
    )
}
