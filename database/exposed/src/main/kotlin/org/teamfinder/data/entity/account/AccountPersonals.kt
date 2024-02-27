package org.teamfinder.data.entity.account

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.account.data.AccountStatuses
import org.teamfinder.data.entity.common.file.LocalFiles

object AccountPersonals : IdTable<Int>("accountpersonal") {
    val pk = integer("id").references(Accounts.id)

    override val id: Column<EntityID<Int>> = pk.entityId()

    val username: Column<String> = varchar(
        "username",
        255
    ).uniqueIndex("accountpersonal_username_key")

    val avatarID: Column<Int?> = integer("avatarid").references(LocalFiles.id).nullable()

    val backgroundID: Column<Int?> = integer("backgroundid").references(LocalFiles.id).nullable()

    val statusID: Column<Int?> =
        integer("statusid").references(AccountStatuses.id).nullable()

    val aboutMeText: Column<String> = text("aboutmetext")
}
