package org.teamfinder.data.model.channel.member

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.member.ChannelMemberRoles

class ChannelMemberRole(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelMemberRole>(ChannelMemberRoles)

    val title by ChannelMemberRoles.title
}
