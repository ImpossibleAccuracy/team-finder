package org.teamfinder.data.comment

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.article.Article
import org.teamfinder.data.game.Game
import java.time.OffsetDateTime

@Entity
class Comment(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(
        name = "primary_sequence",
        sequenceName = "primary_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    var id: Long,

    @Column(name = "CreatedAt", nullable = false)
    var createdAt: OffsetDateTime,

    @Column(name = "Content", nullable = false, columnDefinition = "text")
    var content: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ParentCommentID")
    var parentComment: Comment?,

    @ManyToMany
    @JoinTable(
        name = "CommentArticle",
        joinColumns = [JoinColumn(name = "commentId")],
        inverseJoinColumns = [JoinColumn(name = "articleId")]
    )
    var commentArticleArticles: Set<Article> = HashSet(),

    @ManyToMany
    @JoinTable(
        name = "CommentGame",
        joinColumns = [JoinColumn(name = "commentId")],
        inverseJoinColumns = [JoinColumn(name = "gameId")]
    )
    var commentGameGames: Set<Game> = HashSet(),
)
