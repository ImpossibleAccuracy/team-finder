package org.teamfinder.data.comment

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity

@Entity
class Comment(
    @Column(name = "Content", nullable = false, columnDefinition = "text")
    var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ParentCommentID")
    var parentComment: Comment?,

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "CommentArticle",
//        joinColumns = [JoinColumn(name = "commentId")],
//        inverseJoinColumns = [JoinColumn(name = "articleId")]
//    )
//    var commentArticleArticles: List<Article> = listOf(),
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "CommentGame",
//        joinColumns = [JoinColumn(name = "commentId")],
//        inverseJoinColumns = [JoinColumn(name = "gameId")]
//    )
//    var commentGameGames: List<Game> = listOf(),
) : BaseAuditEntity<Long>()
