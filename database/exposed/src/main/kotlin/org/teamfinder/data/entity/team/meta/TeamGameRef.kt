package org.teamfinder.data.entity.team.meta

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.teamfinder.data.entity.game.Games
import org.teamfinder.data.entity.team.Teams

object TeamGameRef : Table("team_game") {
    val teamID: Column<Int> = integer("teamid").references(Teams.id)

    val gameID: Column<Int> = integer("gameid").references(Games.id)

    override val primaryKey: PrimaryKey = PrimaryKey(
        teamID,
        gameID
    )
}
