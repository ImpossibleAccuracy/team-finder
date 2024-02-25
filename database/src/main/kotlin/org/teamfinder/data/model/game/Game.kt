package org.teamfinder.data.model.game

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.game.Games
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.common.media.MediaCollection

class Game(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Game>(Games)

    val createdAt by Games.createdAt

    val creator by Account referencedOn Games.creatorID

    val title by Games.title

    val description by Games.description

    val creatorStudioName by Games.creatorStudioName

    val media by MediaCollection referencedOn Games.mediaCollectionID

    val validated by Games.validated

    val validatedBy by Account optionalReferencedOn Games.validatedBy
}
