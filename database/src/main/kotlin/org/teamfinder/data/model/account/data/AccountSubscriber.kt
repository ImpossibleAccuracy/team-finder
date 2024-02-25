package org.teamfinder.data.model.account.data

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.data.AccountSubscribers
import org.teamfinder.data.model.account.Account

class AccountSubscriber(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountSubscriber>(AccountSubscribers)

    val createdAt by AccountSubscribers.createdAt

    val account by Account referencedOn AccountSubscribers.accountID

    val subscriber by Account referencedOn AccountSubscribers.subscriberID
}
