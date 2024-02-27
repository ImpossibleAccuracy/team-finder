package org.teamfinder.data.model.account.flow

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.flow.PublicInvites

class PublicInvite(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<PublicInvite>(PublicInvites)

    val createdAt by PublicInvites.createdAt

    val accountID by PublicInvites.accountID

    val inviteID by PublicInvites.inviteID
}
