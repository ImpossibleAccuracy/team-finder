package org.teamfinder.data.model.account

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.AccountPersonals
import org.teamfinder.data.entity.account.Accounts
import org.teamfinder.data.entity.account.security.ref.AccountRoleRef
import org.teamfinder.data.model.account.security.Role

class Account(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Account>(Accounts)

    val createdAt by Accounts.createdAt

    val email by Accounts.email

    val password by Accounts.password

    val personal by AccountPersonal referencedOn AccountPersonals.id

    val roles by Role via AccountRoleRef
}
