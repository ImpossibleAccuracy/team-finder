package org.teamfinder.data.entity.article.userdata

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.account.Accounts
import org.teamfinder.data.entity.article.Articles

object ArticleRatings : IdTable<Int>("articlerating") {
    val articleID: Column<Int> = integer("articleid").references(Articles.id)

    val accountID: Column<Int> = integer("accountid").references(Accounts.id)

    val data: Column<Int> = integer("value")

    override val id: Column<EntityID<Int>>
        get() = articleID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        articleID,
        accountID
    )
}
