package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.channel.keys.ChannelSocialPK
import org.teamfinder.data.channel.meta.ChannelSocial

interface ChannelSocialRepository : JpaRepository<ChannelSocial, ChannelSocialPK>,
    JpaSpecificationExecutor<ChannelSocial>