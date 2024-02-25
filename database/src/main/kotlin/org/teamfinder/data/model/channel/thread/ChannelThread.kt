package org.teamfinder.data.model.channel.thread

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.thread.ChannelThreads
import org.teamfinder.data.model.channel.Channel
import org.teamfinder.data.model.common.room.Room

class ChannelThread(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelThread>(ChannelThreads)

    val createdAt by ChannelThreads.createdAt

    val channel by Channel referencedOn ChannelThreads.channelID

    val title by ChannelThreads.title

    val room by Room referencedOn ChannelThreads.roomID

    val isSecured by ChannelThreads.isSecured
}
