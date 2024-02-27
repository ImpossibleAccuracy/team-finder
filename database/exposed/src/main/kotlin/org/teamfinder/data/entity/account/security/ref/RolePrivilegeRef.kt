package org.teamfinder.data.entity.account.security.ref

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table

object RolePrivilegeRef : Table("role_privilege") {
    val roleID: Column<Int> = integer("roleid").references(org.teamfinder.data.entity.account.security.Roles.id)

    val privilegeID: Column<Int> = integer("privilegeid").references(org.teamfinder.data.entity.account.security.Privileges.id)

    override val primaryKey: PrimaryKey = PrimaryKey(
        roleID,
        privilegeID
    )
}
