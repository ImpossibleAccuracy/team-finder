package org.teamfinder.data.common.room

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.ref.RefAuditEntity
import org.teamfinder.data.common.room.keys.RoomMemberPK

@Entity
class RoomMember(
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
) : RefAuditEntity<RoomMemberPK>()
