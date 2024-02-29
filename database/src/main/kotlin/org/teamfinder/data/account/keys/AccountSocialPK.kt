package org.teamfinder.data.account.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class AccountSocialPK(
    @Column(name = "AccountID", nullable = false)
    val accountId: Long,
    @Column(name = "SocialID", nullable = false)
    val socialId: Long
)
