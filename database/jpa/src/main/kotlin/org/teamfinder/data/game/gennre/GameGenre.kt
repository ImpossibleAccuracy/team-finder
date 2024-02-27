package org.teamfinder.data.game.gennre

import jakarta.persistence.*
import org.teamfinder.data.game.Game
import org.teamfinder.data.game.keys.GameGenrePK

@Entity
class GameGenre(
    @EmbeddedId
    var pk: GameGenrePK,

    @Column(name = "Order", nullable = false)
    var order: Int,

    @MapsId("gameId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameID", nullable = false)
    var game: Game,

    @MapsId("genreId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genreID", nullable = false)
    var genre: Genre,
)
