package org.teamfinder.data.common.room

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity

@Entity
class Room(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeID", nullable = false)
    var type: RoomType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID", nullable = false)
    var creator: Account,
) : BaseAuditEntity<Long>()
