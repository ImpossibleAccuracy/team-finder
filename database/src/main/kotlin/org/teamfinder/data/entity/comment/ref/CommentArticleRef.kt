package org.teamfinder.data.entity.comment.ref

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.teamfinder.data.entity.article.Articles
import org.teamfinder.data.entity.comment.Comments

object CommentArticleRef : Table("comment_article") {
    val commentID: Column<Int> = integer("commentid").references(Comments.id)

    val articleID: Column<Int> = integer("articleid").references(Articles.id)

    override val primaryKey: PrimaryKey = PrimaryKey(
        commentID,
        articleID
    )
}
