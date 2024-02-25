package org.teamfinder.data.entity.comment.ref

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.teamfinder.data.entity.comment.Comments
import org.teamfinder.data.entity.game.Games

object CommentGameRef : Table("comment_game") {
    val commentID: Column<Int> = integer("commentid").references(Comments.id)

    val gameID: Column<Int> = integer("gameid").references(Games.id)

    override val primaryKey: PrimaryKey = PrimaryKey(
        commentID,
        gameID
    )
}
