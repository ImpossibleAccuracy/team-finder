package org.teamfinder.data.entity.game.meta

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.game.Games

object GameDataItems : IdTable<Int>("gamedataitem") {
    val gameID: Column<Int> = integer("gameid").references(Games.id)

    val typeID: Column<Int> = integer("typeid").references(GameDataItemTypes.id)

    val data: Column<String> = varchar("value", 255)

    override val id: Column<EntityID<Int>>
        get() = gameID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        gameID,
        typeID
    )
}
