package org.teamfinder.data.entity.channel.thread

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.channel.member.ChannelMemberRoles

object ChannelThreadRoleRef : IdTable<Int>("channelthread_role") {
    val threadID: Column<Int> = integer("threadid").references(ChannelThreads.id)

    val roleID: Column<Int> = integer("roleid").references(ChannelMemberRoles.id)

    val isAllow: Column<Boolean> = bool("isallow")

    override val id: Column<EntityID<Int>>
        get() = threadID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        threadID,
        roleID
    )
}
