package org.teamfinder.data.model.channel.meta

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.meta.ChannelVisibilities

class ChannelVisibility(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelVisibility>(ChannelVisibilities)

    val title by ChannelVisibilities.title
}
