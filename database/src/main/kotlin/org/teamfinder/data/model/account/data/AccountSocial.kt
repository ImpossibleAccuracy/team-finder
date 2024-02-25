package org.teamfinder.data.model.account.data

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.data.AccountSocials
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.social.Social

class AccountSocial(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<AccountSocial>(AccountSocials)

    val account by Account referencedOn AccountSocials.accountID

    val social by Social referencedOn AccountSocials.socialID

    val data by AccountSocials.data
}
