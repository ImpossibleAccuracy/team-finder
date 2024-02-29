package org.teamfinder.data.account.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class AccountRelationshipPK(
    @Column(name = "FirstID", nullable = false)
    val firstId: Long,
    @Column(name = "SecondID", nullable = false)
    val secondId: Long
)
