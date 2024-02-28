package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.channel.Channel

interface ChannelRepository : JpaRepository<Channel, Long>, JpaSpecificationExecutor<Channel>