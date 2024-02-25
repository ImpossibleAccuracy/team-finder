package org.teamfinder.data.entity.comment

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime

object Comments : IntIdTable("comment", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val accountID: Column<Int> = integer("accountid").references(org.teamfinder.data.entity.account.Accounts.id)

    val content: Column<String> = text("content")

    val parentCommentID: Column<Int?> = integer("parentcommentid").references(id).nullable()
}
