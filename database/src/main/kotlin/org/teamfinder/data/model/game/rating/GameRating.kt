package org.teamfinder.data.model.game.rating

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.game.rating.GameRatings
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.game.Game

class GameRating(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<GameRating>(GameRatings)

    val gameID by Game referencedOn GameRatings.gameID

    val accountID by Account referencedOn GameRatings.accountID

    val data by GameRatings.data
}
