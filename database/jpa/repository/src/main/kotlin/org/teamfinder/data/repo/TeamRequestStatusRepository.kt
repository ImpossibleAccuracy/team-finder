package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.team.request.TeamRequestStatus

interface TeamRequestStatusRepository : JpaRepository<TeamRequestStatus, Long>,
    JpaSpecificationExecutor<TeamRequestStatus>