package org.teamfinder.data.model.account.security

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.security.Privileges

class Privilege(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Privilege>(Privileges)

    val title by Privileges.title
}
