package org.teamfinder.data.repo.search

import org.springframework.data.jpa.domain.Specification
import org.teamfinder.data.account.Account
import org.teamfinder.data.account.AccountPersonal
import java.time.LocalDateTime

object AccountSpecifications {
    @JvmStatic
    fun idEqual(id: Long): Specification<Account> =
        Specification { root, _, criteriaBuilder ->
            criteriaBuilder.equal(
                root.get<Long>("id"),
                id
            )
        }

    @JvmStatic
    fun emailLike(email: String): Specification<Account> =
        Specification { root, _, criteriaBuilder ->
            criteriaBuilder.likeIgnoreCase(
                root.get("email"),
                email
            )
        }

    @JvmStatic
    fun usernameLike(username: String): Specification<Account> =
        Specification { root, _, criteriaBuilder ->
            criteriaBuilder.likeIgnoreCase(
                root.get<AccountPersonal>("personal").get("username"),
                username
            )
        }

    @JvmStatic
    fun createdAfter(date: LocalDateTime): Specification<Account> =
        Specification { root, _, criteriaBuilder ->
            criteriaBuilder.greaterThanOrEqualTo(
                root.get("createdAt"),
                date
            )
        }

    @JvmStatic
    fun createdBefore(date: LocalDateTime): Specification<Account> =
        Specification { root, _, criteriaBuilder ->
            criteriaBuilder.lessThanOrEqualTo(
                root.get("createdAt"),
                date
            )
        }
}
