package org.teamfinder.data.entity.account.data

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import org.teamfinder.data.entity.account.Accounts

object AccountSubscribers : IdTable<Int>("accountsubscriber") {
    val accountID: Column<Int> = integer("accountid").references(Accounts.id)

    val subscriberID: Column<Int> = integer("subscriberid").references(Accounts.id)

    val createdAt: Column<LocalDateTime> = datetime("createdat")

    override val id: Column<EntityID<Int>>
        get() = accountID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        accountID,
        subscriberID
    )
}