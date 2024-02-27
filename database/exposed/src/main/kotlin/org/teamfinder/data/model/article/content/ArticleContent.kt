package org.teamfinder.data.model.article.content

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.article.content.ArticleContents
import org.teamfinder.data.model.article.Article
import org.teamfinder.data.model.common.content.ContentItem

class ArticleContent(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ArticleContent>(ArticleContents)

    val article by Article referencedOn ArticleContents.articleID

    val content by ContentItem referencedOn ArticleContents.contentItemID

    val order by ArticleContents.order
}
