package org.teamfinder.data.model.article.userdata

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.teamfinder.data.entity.article.userdata.ArticleNotes
import org.teamfinder.data.model.account.Account
import org.teamfinder.data.model.article.Article

class ArticleNote(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<ArticleNote>(ArticleNotes)

    val article by Article referencedOn ArticleNotes.articleID

    val account by Account referencedOn ArticleNotes.accountID

    val text by ArticleNotes.text
}
