package org.teamfinder.data.game.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class GameGenrePK(
    @Column(name = "GameID", nullable = false)
    val gameId: Long,
    @Column(name = "GenreID", nullable = false)
    val genreId: Long
)
