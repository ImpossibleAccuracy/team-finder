package org.teamfinder.data.channel.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class ChannelMemberPK(
    @Column(name = "ChannelID", nullable = false)
    val channelId: Long,
    @Column(name = "AccountID", nullable = false)
    val accountId: Long
)
