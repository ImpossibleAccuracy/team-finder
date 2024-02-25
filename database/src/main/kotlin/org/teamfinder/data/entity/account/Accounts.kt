package org.teamfinder.data.entity.account

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime


object Accounts : IntIdTable("account", "id") {
    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val email: Column<String> = varchar("email", 255).uniqueIndex()

    val password: Column<String> = varchar("password", 255)
}
