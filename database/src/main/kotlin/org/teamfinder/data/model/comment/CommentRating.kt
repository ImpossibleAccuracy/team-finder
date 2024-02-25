package org.teamfinder.data.model.comment

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.comment.CommentRatings
import org.teamfinder.data.model.account.Account

class CommentRating(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<CommentRating>(CommentRatings)

    val comment by Comment referencedOn CommentRatings.commentID

    val account by Account referencedOn CommentRatings.accountID

    val isPositive by CommentRatings.isPositive
}
