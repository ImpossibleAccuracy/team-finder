package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.common.room.Room

interface RoomRepository : JpaRepository<Room, Long>, JpaSpecificationExecutor<Room>