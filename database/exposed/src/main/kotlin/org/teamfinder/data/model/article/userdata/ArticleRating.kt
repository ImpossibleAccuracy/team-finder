package org.teamfinder.data.model.article.userdata

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.article.userdata.ArticleRatings
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.article.Article

class ArticleRating(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ArticleRating>(ArticleRatings)

    val article by Article referencedOn ArticleRatings.articleID

    val account by Account referencedOn ArticleRatings.accountID

    val data by ArticleRatings.data
}
