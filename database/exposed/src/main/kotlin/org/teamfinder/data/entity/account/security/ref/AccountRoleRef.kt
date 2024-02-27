package org.teamfinder.data.entity.account.security.ref

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object AccountRoleRef : Table("account_role") {
    val accountID: Column<Int> = integer("accountid").references(org.teamfinder.data.entity.account.Accounts.id)

    val roleID: Column<Int> = integer("roleid").references(org.teamfinder.data.entity.account.security.Roles.id)

    override val primaryKey: PrimaryKey = PrimaryKey(
        accountID,
        roleID
    )
}
