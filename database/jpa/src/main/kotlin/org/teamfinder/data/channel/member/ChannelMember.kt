package org.teamfinder.data.channel.member

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.channel.Channel
import org.teamfinder.data.channel.keys.ChannelMemberPK
import java.time.OffsetDateTime

@Entity
class ChannelMember(
    @EmbeddedId
    var pk: ChannelMemberPK,

    @Column(name = "CreatedAt", nullable = false)
    var createdAt: OffsetDateTime,

    @MapsId("channelId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChannelID", nullable = false)
    var channel: Channel,

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID")
    var role: ChannelMemberRole,
)
