package org.teamfinder.data.model.account.data

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.data.AccountRelationships
import org.teamfinder.data.model.account.Account

class AccountRelationship(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountRelationship>(AccountRelationships)

    val createdAt by AccountRelationships.createdAt

    val first by Account referencedOn AccountRelationships.firstID

    val second by Account referencedOn AccountRelationships.secondID

    val type by AccountRelationshipType referencedOn AccountRelationships.typeID

    val isCreatorFirst by AccountRelationships.creatorFirst
}
