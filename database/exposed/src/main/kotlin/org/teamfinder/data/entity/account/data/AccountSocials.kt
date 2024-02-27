package org.teamfinder.data.entity.account.data

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.account.Accounts
import org.teamfinder.data.entity.social.Socials

object AccountSocials : IdTable<Int>("account_social") {
    val accountID: Column<Int> = integer("accountid").references(Accounts.id)

    val socialID: Column<Int> = integer("socialid").references(Socials.id)

    val data: Column<String> = varchar("value", 255)

    override val id: Column<EntityID<Int>>
        get() = accountID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        accountID,
        socialID
    )
}
