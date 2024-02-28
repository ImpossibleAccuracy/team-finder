package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.channel.keys.ChannelMemberPK
import org.teamfinder.data.channel.member.ChannelMember

interface ChannelMemberRepository : JpaRepository<ChannelMember, ChannelMemberPK>,
    JpaSpecificationExecutor<ChannelMember>