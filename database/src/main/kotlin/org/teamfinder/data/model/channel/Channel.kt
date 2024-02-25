package org.teamfinder.data.model.channel

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.Channels
import org.teamfinder.data.model.channel.meta.ChannelAdmissionPolicy
import org.teamfinder.data.model.channel.meta.ChannelCategory

class Channel(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Channel>(Channels)

    val title by Channels.title

    val category by ChannelCategory referencedOn Channels.categoryID

    val visibility by ChannelVisibility referencedOn Channels.visibilityID

    val admissionPolicy by ChannelAdmissionPolicy referencedOn Channels.admissionPolicyID
}
