package org.teamfinder.data.article.userdata

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.article.Article
import org.teamfinder.data.article.keys.ArticleNotePK
import org.teamfinder.data.base.ref.RefEntity

@Entity
class ArticleNote(
    @MapsId("articleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ArticleID", nullable = false)
    var article: Article,

    @MapsId("accountId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @Column(name = "Text", nullable = false, columnDefinition = "text")
    var text: String,
) : RefEntity<ArticleNotePK>()
