package org.teamfinder.data.article.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class ArticleContentPK(
    @Column(name = "ArticleID", nullable = false)
    val articleId: Long,
    @Column(name = "ContentItemID", nullable = false)
    val contentItemId: Long
)
