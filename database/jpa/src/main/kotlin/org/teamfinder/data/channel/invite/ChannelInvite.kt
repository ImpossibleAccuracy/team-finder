package org.teamfinder.data.channel.invite

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity
import org.teamfinder.data.channel.Channel
import java.time.LocalDateTime

@Entity
class ChannelInvite(
    @Column(name = "ExpiredAt", nullable = true)
    var expiredAt: LocalDateTime?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChannelID", nullable = false)
    var channel: Channel,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,
) : BaseAuditEntity<Long>()
