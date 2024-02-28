package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.account.AccountPersonal

interface AccountPersonalRepository : JpaRepository<AccountPersonal, Long>, JpaSpecificationExecutor<AccountPersonal>