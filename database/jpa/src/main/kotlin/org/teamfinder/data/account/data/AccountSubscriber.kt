package org.teamfinder.data.account.data

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.account.keys.AccountSubscriberPK
import java.time.OffsetDateTime

@Entity
class AccountSubscriber(
    @EmbeddedId
    var pk: AccountSubscriberPK,

    @Column(name = "createdAt", nullable = false)
    var createdAt: OffsetDateTime,

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountID", nullable = false)
    var account: Account,

    @MapsId("subscriberId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subscriberID", nullable = false)
    var subscriber: Account,
)
