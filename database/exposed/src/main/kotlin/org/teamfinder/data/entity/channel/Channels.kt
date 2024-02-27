package org.teamfinder.data.entity.channel

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object Channels : IntIdTable("channel", "id") {
    val title: Column<String> = varchar("title", 255)

    val categoryID: Column<Int> = integer("categoryid").references(id)

    val visibilityID: Column<Int> = integer("visibilityid").references(id)

    val admissionPolicyID: Column<Int> =
        integer("admissionpolicyid").references(id)
}
