package org.teamfinder.data.article.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class ArticleNotePK(
    @Column(name = "ArticleID", nullable = false)
    val articleId: Long,
    @Column(name = "AccountID", nullable = false)
    val accountId: Long
)
