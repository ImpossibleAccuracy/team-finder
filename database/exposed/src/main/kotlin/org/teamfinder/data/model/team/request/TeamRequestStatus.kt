package org.teamfinder.data.model.team.request

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.team.request.TeamRequestStatuses

class TeamRequestStatus(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TeamRequestStatus>(TeamRequestStatuses)

    val title by TeamRequestStatuses.title
}
