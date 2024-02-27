package org.teamfinder.data.common.room.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class RoomMemberPK(
    @Column(name = "RoomID", nullable = false)
    val roomId: Long,
    @Column(name = "MemberID", nullable = false)
    val memberId: Long
)
