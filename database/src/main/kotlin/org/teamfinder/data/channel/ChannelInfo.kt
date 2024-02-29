package org.teamfinder.data.channel

import jakarta.persistence.*
import org.teamfinder.data.common.file.LocalFile

@Entity
class ChannelInfo(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    var id: Long,

    @Column(name = "Description", nullable = false, columnDefinition = "text")
    var description: String,

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    var channel: Channel,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LogoID", nullable = false)
    var logo: LocalFile,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BackgroundID", nullable = false)
    var background: LocalFile,
)
