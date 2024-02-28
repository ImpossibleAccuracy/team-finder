package org.teamfinder.data.common.room.message

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity
import org.teamfinder.data.common.content.ContentItem
import org.teamfinder.data.common.room.Room

@Entity
class Message(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoomID", nullable = false)
    var room: Room,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID", nullable = false)
    var creator: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ParentID")
    var parent: Message?,

    @ManyToMany
    @JoinTable(
        name = "MessageContent",
        joinColumns = [JoinColumn(name = "MessageId")],
        inverseJoinColumns = [JoinColumn(name = "ContentItemId")]
    )
    var contentItems: Set<ContentItem> = HashSet(),
) : BaseAuditEntity<Long>()
