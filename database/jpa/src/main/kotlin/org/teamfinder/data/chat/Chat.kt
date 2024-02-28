package org.teamfinder.data.chat

import jakarta.persistence.*
import org.teamfinder.data.common.file.LocalFile
import org.teamfinder.data.common.room.Room

@Entity
class Chat(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    var id: Long,

    @Column(name = "Title", nullable = false, updatable = false)
    var title: String,

    @Column(name = "Description", columnDefinition = "text")
    var description: String?,

    @Column(name = "IsGroup", nullable = false)
    var isGroup: Boolean,

    @MapsId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    var room: Room,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LogoID")
    var logo: LocalFile?,
)
