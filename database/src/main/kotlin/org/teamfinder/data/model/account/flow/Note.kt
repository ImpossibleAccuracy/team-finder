package org.teamfinder.data.model.account.flow

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.account.flow.Notes
import org.teamfinder.data.model.account.Account

class Note(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Note>(Notes)

    val createdAt by Notes.createdAt

    val account by Account referencedOn Notes.accountID

    val content by Notes.content
}
