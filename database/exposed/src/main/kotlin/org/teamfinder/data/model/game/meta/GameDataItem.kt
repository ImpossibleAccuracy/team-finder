package org.teamfinder.data.model.game.meta

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.game.meta.GameDataItems
import org.teamfinder.data.model.game.Game

class GameDataItem(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<GameDataItem>(GameDataItems)

    val game by Game referencedOn GameDataItems.gameID

    val type by GameDataItemType referencedOn GameDataItems.typeID

    val data by GameDataItems.data
}
