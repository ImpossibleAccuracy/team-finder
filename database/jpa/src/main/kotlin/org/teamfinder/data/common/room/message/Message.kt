package org.teamfinder.data.common.room.message

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.common.content.ContentItem
import org.teamfinder.data.common.room.Room
import java.time.OffsetDateTime

@Entity
class Message(
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
)
