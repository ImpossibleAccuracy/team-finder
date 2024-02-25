package org.teamfinder.data.model.channel.thread

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.thread.ChannelThreadRoleRef

class ChannelThreadRole(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelThreadRole>(ChannelThreadRoleRef)

    val threadID by ChannelThreadRoleRef.threadID

    val roleID by ChannelThreadRoleRef.roleID

    val isAllow by ChannelThreadRoleRef.isAllow
}
