package org.teamfinder.data.model.channel.invite

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.invite.ChannelInvites
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.channel.Channel

class ChannelInvite(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelInvite>(ChannelInvites)

    val createdAt by ChannelInvites.createdAt

    val channel by Channel referencedOn ChannelInvites.channelID

    val account by Account referencedOn ChannelInvites.accountID

    val expiredAt by ChannelInvites.expiredAt
}
