package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.channel.keys.ChannelThreadRolePK
import org.teamfinder.data.channel.thread.ChannelThreadRole

interface ChannelThreadRoleRepository : JpaRepository<ChannelThreadRole, ChannelThreadRolePK>,
    JpaSpecificationExecutor<ChannelThreadRole>