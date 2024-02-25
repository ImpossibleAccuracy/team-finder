package org.teamfinder.data.entity.common.content.variants

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.channel.invite.ChannelInvites
import org.teamfinder.data.entity.common.content.ContentItems

object ContentItemsInvite : IdTable<Int>("contentiteminvite") {
    override val id: Column<EntityID<Int>> = integer("id").references(ContentItems.id).entityId()

    val inviteID: Column<Int> = integer("inviteid").references(ChannelInvites.id)
}
