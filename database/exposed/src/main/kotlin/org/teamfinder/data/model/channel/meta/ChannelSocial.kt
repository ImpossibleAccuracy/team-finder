package org.teamfinder.data.model.channel.meta

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.meta.ChannelSocials
import org.teamfinder.data.model.channel.Channel
import org.teamfinder.data.model.social.Social

class ChannelSocial(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelSocial>(ChannelSocials)

    val channel by Channel referencedOn ChannelSocials.channelID

    val social by Social referencedOn ChannelSocials.socialID

    val data by ChannelSocials.data
}
