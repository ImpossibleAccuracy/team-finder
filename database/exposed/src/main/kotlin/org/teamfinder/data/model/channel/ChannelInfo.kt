package org.teamfinder.data.model.channel

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.ChannelInfos
import org.teamfinder.data.model.common.file.LocalFile

class ChannelInfo(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelInfo>(ChannelInfos)

    val description by ChannelInfos.description

    val logo by LocalFile referencedOn ChannelInfos.logoID

    val backgroundID by LocalFile referencedOn ChannelInfos.backgroundID
}
