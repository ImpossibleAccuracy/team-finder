package org.teamfinder.data.model.account.security

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.security.Roles
import org.teamfinder.data.entity.account.security.ref.RolePrivilegeRef

class Role(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Role>(Roles)

    val title by Roles.title

    val privileges by Privilege via RolePrivilegeRef
}
