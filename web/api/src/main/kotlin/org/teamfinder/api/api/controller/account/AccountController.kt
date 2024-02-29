package org.teamfinder.api.api.controller.account

import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.teamfinder.api.data.model.Pagination
import org.teamfinder.api.data.model.SortRule
import org.teamfinder.api.schema.dto.AccountFilter
import org.teamfinder.api.service.account.AccountService
import org.teamfinder.data.account.Account
import kotlin.jvm.optionals.getOrNull

@Service
class AccountController(
    private val accountService: AccountService
) {
    companion object {
        val sortVariants: Map<String, SortRule<Account>> = mapOf(
            "id" to Sort.by("id"),
            "email" to Sort.by("email"),
            "createdAt" to Sort.by("createdAt"),
        ).map {
            it.key to SortRule<Account>(it.value)
        }.toMap()

        val defaultSort = sortVariants["id"]!!
    }

    suspend fun account(id: Long): Account? =
        accountService.getAccount(id).getOrNull()

    suspend fun accounts(filter: AccountFilter?, pagination: Pagination, sort: SortRule<Account>): List<Account> =
        accountService.getAccounts(pagination, sort, filter)
}
