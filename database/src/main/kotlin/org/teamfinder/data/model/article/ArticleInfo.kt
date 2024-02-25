package org.teamfinder.data.model.article

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.article.ArticleInfos
import org.teamfinder.data.model.account.Account

class ArticleInfo(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ArticleInfo>(ArticleInfos)

    val account by Account referencedOn ArticleInfos.id

    val gameID by ArticleInfos.gameID

    val previewID by ArticleInfos.previewID

    val shortDescription by ArticleInfos.shortDescription

    val longDescription by ArticleInfos.longDescription

    val timeToRead by ArticleInfos.timeToRead
}
