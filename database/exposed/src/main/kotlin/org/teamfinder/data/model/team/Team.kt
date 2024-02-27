package org.teamfinder.data.model.team

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.team.Teams
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.team.meta.TeamStatus
import org.teamfinder.data.model.team.meta.TeamType

class Team(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Team>(Teams)

    val createdAt by Teams.createdAt

    val creator by Account referencedOn Teams.creatorID

    val title by Teams.title

    val description by Teams.description

    val typeID by TeamType referencedOn Teams.typeID

    val statusID by TeamStatus referencedOn Teams.statusID

    val totalPersonAmount by Teams.totalPersonAmount
}
