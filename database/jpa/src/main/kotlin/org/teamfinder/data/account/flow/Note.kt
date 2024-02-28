package org.teamfinder.data.account.flow

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity

@Entity
class Note(
    @Column(name = "Content", nullable = false, columnDefinition = "text")
    var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,
) : BaseAuditEntity<Long>()
