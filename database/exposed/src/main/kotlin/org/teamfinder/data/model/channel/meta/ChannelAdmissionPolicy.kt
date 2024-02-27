package org.teamfinder.data.model.channel.meta

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.channel.meta.ChannelAdmissionPolicies

class ChannelAdmissionPolicy(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ChannelAdmissionPolicy>(ChannelAdmissionPolicies)

    val title by ChannelAdmissionPolicies.title
}
