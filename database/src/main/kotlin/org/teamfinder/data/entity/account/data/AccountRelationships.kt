package org.teamfinder.data.entity.account.data

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import org.teamfinder.data.entity.account.Accounts

object AccountRelationships : IdTable<Int>("accountrelationship") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val firstID: Column<Int> = integer("firstid").references(Accounts.id)

    val secondID: Column<Int> = integer("secondid").references(Accounts.id)

    val typeID: Column<Int> =
        integer("typeid").references(AccountRelationshipTypes.id)

    val creatorFirst: Column<Boolean> = bool("creatorfirst")

    override val id: Column<EntityID<Int>>
        get() = firstID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        firstID,
        secondID
    )
}
