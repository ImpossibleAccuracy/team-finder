package org.teamfinder.data.account.flow

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.account.keys.PublicInvitePK
import org.teamfinder.data.base.ref.RefAuditEntity
import org.teamfinder.data.channel.invite.ChannelInvite

@Entity
class PublicInvite(
    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @MapsId("inviteId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InviteID", nullable = false)
    var invite: ChannelInvite,
) : RefAuditEntity<PublicInvitePK>()
