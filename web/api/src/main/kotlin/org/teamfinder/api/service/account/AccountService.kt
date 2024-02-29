package org.teamfinder.api.service.account

import org.teamfinder.api.data.model.Pagination
import org.teamfinder.api.data.model.SortRule
import org.teamfinder.api.schema.dto.AccountFilter
import org.teamfinder.data.account.Account
import java.util.*

interface AccountService {
    fun getAccount(id: Long): Optional<Account>

    fun getAccountByEmail(email: String): Optional<Account>

    fun getAccounts(
        pagination: Pagination,
        sort: SortRule<Account>,
        filter: AccountFilter?
    ): List<Account>

    fun save(data: Account): Account
}
