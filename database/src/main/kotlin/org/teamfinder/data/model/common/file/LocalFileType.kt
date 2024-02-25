package org.teamfinder.data.model.common.file

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.file.LocalFileTypes

class LocalFileType(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<LocalFileType>(LocalFileTypes)

    val title by LocalFileTypes.title
}
