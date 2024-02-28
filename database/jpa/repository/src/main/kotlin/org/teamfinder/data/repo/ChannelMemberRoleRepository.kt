package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.channel.member.ChannelMemberRole

interface ChannelMemberRoleRepository : JpaRepository<ChannelMemberRole, Long>,
    JpaSpecificationExecutor<ChannelMemberRole>