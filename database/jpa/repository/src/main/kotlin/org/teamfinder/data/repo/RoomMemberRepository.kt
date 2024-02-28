package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.common.room.RoomMember
import org.teamfinder.data.common.room.keys.RoomMemberPK

interface RoomMemberRepository : JpaRepository<RoomMember, RoomMemberPK>, JpaSpecificationExecutor<RoomMember>