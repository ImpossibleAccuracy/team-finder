package org.teamfinder.data.account.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class PublicInvitePK(
    @Column(name = "AccountID", nullable = false)
    val accountId: Long,
    @Column(name = "InviteID", nullable = false)
    val inviteId: Long
)
