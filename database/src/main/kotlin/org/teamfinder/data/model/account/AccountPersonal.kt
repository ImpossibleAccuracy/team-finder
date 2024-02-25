package org.teamfinder.data.model.account

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.AccountPersonals
import org.teamfinder.data.model.account.data.AccountStatus
import org.teamfinder.data.model.common.file.LocalFile

class AccountPersonal(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountPersonal>(AccountPersonals)

    val account by Account referencedOn AccountPersonals.id

    val username by AccountPersonals.username

    val status by AccountStatus optionalReferencedOn AccountPersonals.statusID

    val aboutMeText by AccountPersonals.aboutMeText

    val avatar by LocalFile optionalReferencedOn AccountPersonals.avatarID

    val background by LocalFile optionalReferencedOn AccountPersonals.backgroundID
}
