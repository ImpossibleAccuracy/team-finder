package org.teamfinder.data.account.data

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.account.keys.AccountRelationshipPK
import java.time.OffsetDateTime

@Entity
class AccountRelationship(
    @EmbeddedId
    var pk: AccountRelationshipPK,

    @Column(name = "CreatedAt", nullable = false)
    var createdAt: OffsetDateTime,

    @Column(name = "CreatorFirst", nullable = false)
    var creatorFirst: Boolean,

    @MapsId("firstId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FirstID", nullable = false)
    var first: Account,

    @MapsId("secondId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SecondID", nullable = false)
    var second: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeID", nullable = false)
    var type: AccountRelationshipType,
)
