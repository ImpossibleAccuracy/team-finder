package org.teamfinder.data.entity.game.rating

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.account.Accounts
import org.teamfinder.data.entity.game.Games

object GameRatings : IdTable<Int>("gamerating") {
    val gameID: Column<Int> = integer("gameid").references(Games.id)

    val accountID: Column<Int> = integer("accountid").references(Accounts.id)

    val data: Column<Int> = integer("value")

    override val id: Column<EntityID<Int>>
        get() = gameID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        gameID,
        accountID
    )
}
