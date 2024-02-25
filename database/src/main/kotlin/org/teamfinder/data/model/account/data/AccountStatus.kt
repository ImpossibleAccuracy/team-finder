package org.teamfinder.data.model.account.data

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.data.AccountStatuses

class AccountStatus(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountStatus>(AccountStatuses)

    val title by AccountStatuses.title
}
