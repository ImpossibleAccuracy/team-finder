package org.teamfinder.data.game.meta

import jakarta.persistence.*
import org.teamfinder.data.game.Game
import org.teamfinder.data.game.keys.GameDataItemPK

@Entity
class GameDataItem(
    @EmbeddedId
    var pk: GameDataItemPK,

    @MapsId("gameId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "GameID", nullable = false)
    var game: Game,

    @MapsId("typeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeID", nullable = false)
    var type: GameDataType,

    @Column(name = "Value", nullable = false)
    var value: String,
)
