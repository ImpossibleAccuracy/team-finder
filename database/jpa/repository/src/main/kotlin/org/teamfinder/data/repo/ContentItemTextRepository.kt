package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.common.content.variant.ContentItemText

interface ContentItemTextRepository : JpaRepository<ContentItemText, Long>, JpaSpecificationExecutor<ContentItemText>