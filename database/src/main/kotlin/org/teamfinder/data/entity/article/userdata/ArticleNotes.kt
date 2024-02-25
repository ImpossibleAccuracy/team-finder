package org.teamfinder.data.entity.article.userdata

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object ArticleNotes : IdTable<Int>("articlenote") {
    val articleID: Column<Int> = integer("articleid").references(org.teamfinder.data.entity.article.Articles.id)

    val accountID: Column<Int> = integer("accountid").references(org.teamfinder.data.entity.account.Accounts.id)

    val text: Column<String> = text("text")

    override val id: Column<EntityID<Int>>
        get() = articleID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        articleID,
        accountID
    )
}