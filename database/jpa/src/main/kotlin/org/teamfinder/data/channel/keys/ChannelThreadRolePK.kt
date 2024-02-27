package org.teamfinder.data.channel.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class ChannelThreadRolePK(
    @Column(name = "ThreadID", nullable = false)
    val threadId: Long,
    @Column(name = "RoleID", nullable = false)
    val roleId: Long
)
