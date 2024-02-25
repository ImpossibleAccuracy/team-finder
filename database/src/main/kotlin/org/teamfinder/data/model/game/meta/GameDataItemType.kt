package org.teamfinder.data.model.game.meta

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.game.meta.GameDataItemTypes

class GameDataItemType(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<GameDataItemType>(GameDataItemTypes)

    val title by GameDataItemTypes.title
}
