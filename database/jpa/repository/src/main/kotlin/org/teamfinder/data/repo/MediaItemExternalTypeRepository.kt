package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.common.media.MediaItemExternalType

interface MediaItemExternalTypeRepository : JpaRepository<MediaItemExternalType, Long>,
    JpaSpecificationExecutor<MediaItemExternalType>