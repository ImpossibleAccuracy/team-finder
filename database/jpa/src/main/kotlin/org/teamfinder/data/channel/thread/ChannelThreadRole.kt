package org.teamfinder.data.channel.thread

import jakarta.persistence.*
import org.teamfinder.data.channel.keys.ChannelThreadRolePK
import org.teamfinder.data.channel.member.ChannelMemberRole

@Entity
class ChannelThreadRole(
    @EmbeddedId
    var pk: ChannelThreadRolePK,

    @MapsId("threadId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "threadID", nullable = false)
    var thread: ChannelThread,

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "roleID", nullable = false)
    var role: ChannelMemberRole,

    @Column(name = "createdAt", nullable = false)
    var isAllow: Boolean,
)
