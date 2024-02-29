package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.common.content.ContentItemType

interface ContentItemTypeRepository : JpaRepository<ContentItemType, Long>, JpaSpecificationExecutor<ContentItemType>