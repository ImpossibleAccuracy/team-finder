package org.teamfinder.data.account.data

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.account.keys.AccountRelationshipPK
import org.teamfinder.data.base.ref.RefAuditEntity

@Entity
class AccountRelationship(
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
) : RefAuditEntity<AccountRelationshipPK>()
