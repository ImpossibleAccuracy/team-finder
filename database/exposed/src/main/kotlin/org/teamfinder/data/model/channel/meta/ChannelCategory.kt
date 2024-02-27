package org.teamfinder.data.model.channel.meta

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.meta.ChannelCategories

class ChannelCategory(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelCategory>(ChannelCategories)

    val title by ChannelCategories.title
}
