package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.channel.meta.ChannelCategory

interface ChannelCategoryRepository : JpaRepository<ChannelCategory, Long>, JpaSpecificationExecutor<ChannelCategory>