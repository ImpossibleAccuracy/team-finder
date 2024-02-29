package org.teamfinder.data.channel.thread

import jakarta.persistence.*
import org.teamfinder.data.base.ref.RefEntity
import org.teamfinder.data.channel.keys.ChannelThreadRolePK
import org.teamfinder.data.channel.member.ChannelMemberRole

@Entity(name = "ChannelThread_Role")
class ChannelThreadRole(
    @MapsId("threadId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ThreadID", nullable = false)
    var thread: ChannelThread,

    @MapsId("roleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID", nullable = false)
    var role: ChannelMemberRole,

    @Column(name = "IsAllow", nullable = false)
    var isAllow: Boolean,
) : RefEntity<ChannelThreadRolePK>()
