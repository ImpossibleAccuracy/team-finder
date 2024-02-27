package org.teamfinder.data.entity.channel.meta

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object ChannelAdmissionPolicies : IntIdTable("channeladmissionpolicy", "id") {
    val title: Column<String> = varchar(
        "title",
        255
    ).uniqueIndex()
}
