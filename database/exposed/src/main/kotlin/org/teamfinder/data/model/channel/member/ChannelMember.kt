package org.teamfinder.data.model.channel.member

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.member.ChannelMemberRef
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.channel.Channel

class ChannelMember(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelMember>(ChannelMemberRef)

    val createdAt by ChannelMemberRef.createdAt

    val channel by Channel referencedOn ChannelMemberRef.channelID

    val account by Account referencedOn ChannelMemberRef.accountID

    val role by ChannelMemberRole optionalReferencedOn ChannelMemberRef.roleID
}
