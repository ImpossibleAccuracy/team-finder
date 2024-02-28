package org.teamfinder.data.channel.thread

import jakarta.persistence.*
import org.teamfinder.data.base.BaseAuditEntity
import org.teamfinder.data.channel.Channel
import org.teamfinder.data.common.room.Room

@Entity
class ChannelThread(
    @Column(name = "Title", nullable = false)
    var title: String,

    @Column(name = "IsSecured", nullable = false)
    var isSecured: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ChannelID", nullable = false)
    var channel: Channel,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoomID", nullable = false)
    var room: Room,
) : BaseAuditEntity<Long>()
