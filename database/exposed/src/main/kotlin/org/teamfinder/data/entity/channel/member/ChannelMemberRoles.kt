package org.teamfinder.data.entity.channel.member

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object ChannelMemberRoles : IntIdTable("channelmemberrole", "id") {
    val title: Column<String> = varchar(
        "title",
        255
    ).uniqueIndex()
}
