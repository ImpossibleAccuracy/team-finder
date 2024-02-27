package org.teamfinder.data.entity.team.request

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object TeamRequests : IntIdTable("teamrequest", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val accountID: Column<Int> = integer("accountid").references(id)

    val teamID: Column<Int> = integer("teamid").references(id)

    val statusID: Column<Int> = integer("statusid").references(id)
}
