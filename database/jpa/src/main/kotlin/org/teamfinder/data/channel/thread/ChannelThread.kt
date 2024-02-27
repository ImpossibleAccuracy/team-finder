package org.teamfinder.data.channel.thread

import jakarta.persistence.*
import org.teamfinder.data.channel.Channel
import org.teamfinder.data.common.room.Room
import java.time.OffsetDateTime

@Entity
class ChannelThread(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(
        name = "primary_sequence",
        sequenceName = "primary_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    var id: Long,

    @Column(name = "CreatedAt", nullable = false)
    var createdAt: OffsetDateTime,

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
)
