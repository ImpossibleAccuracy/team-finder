package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.team.meta.TeamStatus

interface TeamStatusRepository : JpaRepository<TeamStatus, Long>, JpaSpecificationExecutor<TeamStatus>