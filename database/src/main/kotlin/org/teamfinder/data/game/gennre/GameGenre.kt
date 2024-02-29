package org.teamfinder.data.game.gennre

import jakarta.persistence.*
import org.teamfinder.data.base.ref.RefEntity
import org.teamfinder.data.game.Game
import org.teamfinder.data.game.keys.GameGenrePK

@Entity(name = "Game_Genre")
class GameGenre(
    @Column(name = "Order", nullable = false)
    var order: Int,

    @MapsId("gameId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GameID", nullable = false)
    var game: Game,

    @MapsId("genreId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GenreID", nullable = false)
    var genre: Genre,
) : RefEntity<GameGenrePK>()
