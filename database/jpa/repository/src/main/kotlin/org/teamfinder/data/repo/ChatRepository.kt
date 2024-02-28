package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.chat.Chat

interface ChatRepository : JpaRepository<Chat, Long>, JpaSpecificationExecutor<Chat>