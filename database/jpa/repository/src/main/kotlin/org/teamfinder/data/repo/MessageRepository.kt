package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.common.room.message.Message

interface MessageRepository : JpaRepository<Message, Long>, JpaSpecificationExecutor<Message>