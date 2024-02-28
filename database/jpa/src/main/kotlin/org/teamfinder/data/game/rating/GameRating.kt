package org.teamfinder.data.game.rating

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.ref.RefEntity
import org.teamfinder.data.game.Game
import org.teamfinder.data.game.keys.GameRatingPK

@Entity
class GameRating(
    @MapsId("gameId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gameID", nullable = false)
    var game: Game,

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accountID", nullable = false)
    var account: Account,

    @Column(name = "createdAt", nullable = false)
    var value: Int,
) : RefEntity<GameRatingPK>()
