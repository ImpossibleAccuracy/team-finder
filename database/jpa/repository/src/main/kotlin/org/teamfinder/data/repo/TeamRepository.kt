package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.team.Team

interface TeamRepository : JpaRepository<Team, Long>, JpaSpecificationExecutor<Team>