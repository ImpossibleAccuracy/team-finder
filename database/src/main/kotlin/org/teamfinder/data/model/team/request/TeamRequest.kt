package org.teamfinder.data.model.team.request

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.team.request.TeamRequests
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.team.Team

class TeamRequest(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<TeamRequest>(TeamRequests)

    val createdAt by TeamRequests.createdAt

    val account by Account referencedOn TeamRequests.accountID

    val team by Team referencedOn TeamRequests.teamID

    val status by TeamRequestStatus referencedOn TeamRequests.statusID
}
