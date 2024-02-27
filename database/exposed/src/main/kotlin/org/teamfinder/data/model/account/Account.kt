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

    var createdAt by Accounts.createdAt

    var email by Accounts.email

    var password by Accounts.password

    val personal by AccountPersonal optionalBackReferencedOn AccountPersonals.pk

    val roles by Role via AccountRoleRef
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Account

        if (createdAt != other.createdAt) return false
        if (email != other.email) return false
        if (password != other.password) return false

        return true
    }

    override fun hashCode(): Int {
        var result = createdAt.hashCode()
        result = 31 * result + email.hashCode()
        result = 31 * result + password.hashCode()
        return result
    }

    override fun toString(): String {
        return "Account(createdAt=$createdAt, email='$email')"
    }
}
