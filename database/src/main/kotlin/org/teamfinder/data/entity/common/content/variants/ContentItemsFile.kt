package org.teamfinder.data.entity.common.content.variants

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.common.content.ContentItems
import org.teamfinder.data.entity.common.file.LocalFiles

object ContentItemsFile : IdTable<Int>("contentitemfile") {
    override val id: Column<EntityID<Int>> = integer("id").references(ContentItems.id).entityId()

    val fileID: Column<Int> = integer("fileid").references(LocalFiles.id)

    override val primaryKey: PrimaryKey = PrimaryKey(
        id,
        fileID
    )
}
