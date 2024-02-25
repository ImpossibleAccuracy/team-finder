package org.teamfinder.data.model.comment

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.comment.Comments
import org.teamfinder.data.model.account.Account

class Comment(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Comment>(Comments)

    val createdAt by Comments.createdAt

    val account by Account referencedOn Comments.accountID

    val content by Comments.accountID

    val parentComment by Comment referencedOn Comments.accountID
}
