package org.teamfinder.data.entity.account.flow

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import org.teamfinder.data.entity.account.Accounts
import org.teamfinder.data.entity.channel.invite.ChannelInvites

object PublicInvites : IdTable<Int>("publicinvite") {
    val accountID: Column<Int> = integer("accountid").references(Accounts.id)

    val inviteID: Column<Int> = integer("inviteid").references(ChannelInvites.id)

    val createdAt: Column<LocalDateTime> = datetime("createdat")

    override val id: Column<EntityID<Int>>
        get() = accountID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        accountID,
        inviteID
    )
}
