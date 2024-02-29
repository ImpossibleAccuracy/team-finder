package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.common.media.MediaCollection

interface MediaCollectionRepository : JpaRepository<MediaCollection, Long>, JpaSpecificationExecutor<MediaCollection>