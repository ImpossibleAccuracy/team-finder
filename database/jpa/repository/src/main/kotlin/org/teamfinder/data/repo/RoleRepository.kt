package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.account.security.Role

interface RoleRepository : JpaRepository<Role, Long>, JpaSpecificationExecutor<Role>