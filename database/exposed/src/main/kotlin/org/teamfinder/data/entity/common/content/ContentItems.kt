package org.teamfinder.data.entity.common.content

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Column

object ContentItems : IntIdTable("contentitem", "id") {
    val subjectTypeID: Column<Int> = integer("subjecttypeid").references(id)
}
