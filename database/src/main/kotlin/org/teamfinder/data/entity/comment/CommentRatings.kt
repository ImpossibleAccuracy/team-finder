package org.teamfinder.data.entity.comment

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.account.Accounts

object CommentRatings : IdTable<Int>("commentrating") {
    val commentID: Column<Int> = integer("commentid").references(Comments.id)

    val accountID: Column<Int> = integer("accountid").references(Accounts.id)

    val isPositive: Column<Boolean> = bool("ispositive")

    override val id: Column<EntityID<Int>>
        get() = commentID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        commentID,
        accountID
    )
}
