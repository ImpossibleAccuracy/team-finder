package org.teamfinder.data.article.userdata

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.article.Article
import org.teamfinder.data.article.keys.ArticleRatingPK
import org.teamfinder.data.base.ref.RefEntity

@Entity
class ArticleRating(
    @MapsId("articleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ArticleID", nullable = false)
    var article: Article,

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @Column(name = "Value", nullable = false)
    var value: Int,
) : RefEntity<ArticleRatingPK>()
