package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.team.meta.TeamType

interface TeamTypeRepository : JpaRepository<TeamType, Long>, JpaSpecificationExecutor<TeamType>