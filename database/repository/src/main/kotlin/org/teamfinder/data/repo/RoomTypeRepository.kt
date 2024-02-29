package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.common.room.RoomType

interface RoomTypeRepository : JpaRepository<RoomType, Long>, JpaSpecificationExecutor<RoomType>