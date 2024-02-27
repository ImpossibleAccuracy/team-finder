package org.teamfinder.data.entity.channel.meta

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object ChannelCategories : IntIdTable("channelcategory", "id") {
    val title: Column<String> = varchar(
        "title",
        255
    ).uniqueIndex()
}
