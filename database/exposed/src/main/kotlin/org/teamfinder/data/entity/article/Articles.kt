package org.teamfinder.data.entity.article

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Articles : IntIdTable("article", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val title: Column<String> = varchar("title", 255).uniqueIndex()

    val creatorID: Column<Int> = integer("creatorid").references(org.teamfinder.data.entity.account.Accounts.id)
}
