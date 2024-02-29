package org.teamfinder.data.account.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class AccountSubscriberPK(
    @Column(name = "AccountID", nullable = false)
    val accountId: Long,
    @Column(name = "SubscriberID", nullable = false)
    val subscriberId: Long
)
