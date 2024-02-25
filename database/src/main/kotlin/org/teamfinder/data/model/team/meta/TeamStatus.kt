package org.teamfinder.data.model.team.meta

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.team.meta.TeamStatuses

class TeamStatus(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TeamStatus>(TeamStatuses)

    val title by TeamStatuses.title
}
