package org.teamfinder.data.entity.common.room.message

import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.Table
import org.teamfinder.data.entity.common.content.ContentItems

object MessageContentRef : Table("messagecontent") {
    val messageID: Column<Int> = integer("messageid").references(Messages.id)

    val contentItemID: Column<Int> = integer("contentitemid").references(ContentItems.id)

    override val primaryKey: PrimaryKey = PrimaryKey(
        messageID,
        contentItemID
    )
}
