package org.teamfinder.api.data.payload.filter

import org.springframework.data.jpa.domain.Specification
import org.teamfinder.api.schema.dto.AccountFilter
import org.teamfinder.data.account.Account
import org.teamfinder.data.repo.search.AccountSpecifications
import org.teamfinder.data.repo.search.createDefaultSpec
import org.teamfinder.data.repo.search.specificationsList

fun AccountFilter?.toCriteriaApi(): Specification<Account> = this?.let {
    specificationsList(
        email?.let { AccountSpecifications.emailLike(it) },
        username?.let { AccountSpecifications.usernameLike(it) },
        createdAt?.from?.let { AccountSpecifications.createdAfter(it) },
        createdAt?.to?.let { AccountSpecifications.createdBefore(it) },
    )
} ?: createDefaultSpec()
