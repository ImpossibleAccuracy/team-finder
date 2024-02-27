package org.teamfinder.data.model.team.meta

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.team.meta.TeamTypes

class TeamType(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TeamType>(TeamTypes)

    val title by TeamTypes.title
}
