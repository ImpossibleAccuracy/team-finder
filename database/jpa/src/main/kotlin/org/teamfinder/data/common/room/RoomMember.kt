package org.teamfinder.data.common.room

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.common.room.keys.RoomMemberPK
import java.time.OffsetDateTime

@Entity
class RoomMember(
    @EmbeddedId
    var pk: RoomMemberPK,

    @Column(name = "CreatedAt", nullable = false)
    var createdAt: OffsetDateTime,

    @Column(name = "IsAdmin", nullable = false)
    var isAdmin: Boolean,

    @MapsId("roomId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoomID", nullable = false)
    var room: Room,

    @MapsId("memberId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MemberID", nullable = false)
    var member: Account,
)
