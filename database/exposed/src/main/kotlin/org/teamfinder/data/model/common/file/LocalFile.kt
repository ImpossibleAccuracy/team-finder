package org.teamfinder.data.model.common.file

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.common.file.LocalFiles

class LocalFile(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<LocalFile>(LocalFiles)

    val createdAt by LocalFiles.createdAt

    val type by LocalFileType referencedOn LocalFiles.type

    val path by LocalFiles.path

    val hash by LocalFiles.hash
}
