package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.channel.invite.ChannelInvite

interface ChannelInviteRepository : JpaRepository<ChannelInvite, Long>, JpaSpecificationExecutor<ChannelInvite>