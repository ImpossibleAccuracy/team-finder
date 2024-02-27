package org.teamfinder.data.account.flow

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.account.keys.PublicInvitePK
import org.teamfinder.data.channel.invite.ChannelInvite
import java.time.OffsetDateTime

@Entity
class PublicInvite(
    @EmbeddedId
    var pk: PublicInvitePK,

    @Column(name = "CreatedAt", nullable = false)
    var createdAt: OffsetDateTime,

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @MapsId("inviteId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InviteID", nullable = false)
    var invite: ChannelInvite,
)
