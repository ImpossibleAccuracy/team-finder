package org.teamfinder.data.article.content

import jakarta.persistence.*
import org.teamfinder.data.article.Article
import org.teamfinder.data.article.keys.ArticleContentPK
import org.teamfinder.data.base.ref.RefEntity
import org.teamfinder.data.common.content.ContentItem

@Entity
class ArticleContent(
    @MapsId("articleId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ArticleID", nullable = false)
    var article: Article,

    @MapsId("contentItemId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ContentItemID", nullable = false)
    var contentItem: ContentItem,

    @Column(name = "Order", nullable = false)
    var order: Int,
) : RefEntity<ArticleContentPK>()
