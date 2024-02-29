package org.teamfinder.api.service.account

import org.springframework.stereotype.Service
import org.teamfinder.api.data.model.Pagination
import org.teamfinder.api.data.model.SortRule
import org.teamfinder.api.data.payload.filter.toCriteriaApi
import org.teamfinder.api.data.utils.toPageable
import org.teamfinder.api.schema.dto.AccountFilter
import org.teamfinder.data.account.Account
import org.teamfinder.data.repo.AccountRepository
import java.util.*

@Service
class AccountServiceImpl(
    private val accountRepository: AccountRepository
) : AccountService {
    override fun getAccount(id: Long): Optional<Account> =
        accountRepository.findById(id)

    override fun getAccountByEmail(email: String): Optional<Account> =
        accountRepository.findByEmailIgnoreCase(email)

    override fun getAccounts(
        pagination: Pagination,
        sort: SortRule<Account>,
        filter: AccountFilter?
    ): List<Account> =
        accountRepository
            .findAll(filter.toCriteriaApi(), pagination.toPageable(sort))
            .toList()

    override fun save(data: Account): Account =
        accountRepository.save(data)
}
