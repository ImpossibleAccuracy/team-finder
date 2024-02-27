package org.teamfinder.data.model.social

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.social.Socials
import org.teamfinder.data.model.common.file.LocalFile

class Social(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Social>(Socials)

    val createdAt by Socials.createdAt

    val title by Socials.title

    val logo by LocalFile optionalReferencedOn Socials.logoID
}
