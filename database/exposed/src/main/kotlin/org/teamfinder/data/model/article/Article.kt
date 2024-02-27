package org.teamfinder.data.model.article

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.article.Articles
import org.teamfinder.data.model.account.Account

class Article(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<Article>(Articles)

    val createdAt by Articles.createdAt

    val title by Articles.title

    val creator by Account referencedOn Articles.creatorID
}
