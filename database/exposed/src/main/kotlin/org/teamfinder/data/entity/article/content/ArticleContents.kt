package org.teamfinder.data.entity.article.content

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column

object ArticleContents : IdTable<Int>("articlecontent") {
    val articleID: Column<Int> = integer("articleid").references(org.teamfinder.data.entity.article.Articles.id)

    val contentItemID: Column<Int> =
        integer("contentitemid").references(org.teamfinder.data.entity.common.content.ContentItems.id)

    val order: Column<Int> = integer("order")

    override val id: Column<EntityID<Int>>
        get() = articleID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        articleID,
        contentItemID
    )

    init {
        uniqueIndex(
            articleID,
            order
        )
    }
}
