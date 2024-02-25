package org.teamfinder.data.entity.common.room

import kotlinx.datetime.LocalDateTime
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IdTable
import org.jetbrains.exposed.sql.Column
import org.jetbrains.exposed.sql.kotlin.datetime.datetime
import org.teamfinder.data.entity.account.Accounts

object RoomMembers : IdTable<Int>("roommember") {
    val roomID: Column<Int> = integer("roomid").references(Rooms.id)

    val memberID: Column<Int> = integer("memberid").references(Accounts.id)

    val createdAt: Column<LocalDateTime> = datetime("createdat")

    val isAdmin: Column<Boolean> = bool("isadmin")

    override val id: Column<EntityID<Int>>
        get() = roomID.entityId()

    override val primaryKey: PrimaryKey = PrimaryKey(
        roomID,
        memberID
    )
}
