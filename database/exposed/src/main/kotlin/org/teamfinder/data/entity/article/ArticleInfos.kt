package org.teamfinder.data.entity.article

import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.teamfinder.data.entity.common.file.LocalFiles
import org.teamfinder.data.entity.game.Games

object ArticleInfos : IdTable<Int>("articleinfo") {
    override val id: Column<EntityID<Int>> = integer("id").references(Articles.id).entityId()

    val gameID: Column<Int?> = integer("gameid").references(Games.id).nullable()

    val previewID: Column<Int> = integer("previewid").references(LocalFiles.id)

    val shortDescription: Column<String> = text("shortdescription")

    val longDescription: Column<String> = text("longdescription")

    val timeToRead: Column<Int> = integer("timetoread")
}
