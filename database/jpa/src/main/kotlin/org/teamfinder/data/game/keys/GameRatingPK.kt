package org.teamfinder.data.game.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class GameRatingPK(
    @Column(name = "GameID", nullable = false)
    val gameId: Long,
    @Column(name = "AccountID", nullable = false)
    val accountId: Long
)
