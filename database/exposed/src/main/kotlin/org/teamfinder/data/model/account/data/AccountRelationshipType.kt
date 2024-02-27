package org.teamfinder.data.model.account.data

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.data.AccountRelationshipTypes

class AccountRelationshipType(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountRelationshipType>(AccountRelationshipTypes)

    val title by AccountRelationshipTypes.title
}
