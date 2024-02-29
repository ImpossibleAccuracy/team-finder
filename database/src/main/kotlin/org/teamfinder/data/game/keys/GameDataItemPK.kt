package org.teamfinder.data.game.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class GameDataItemPK(
    @Column(name = "GameID", nullable = false)
    val gameId: Long,
    @Column(name = "TypeID", nullable = false)
    val typeId: Long
)
