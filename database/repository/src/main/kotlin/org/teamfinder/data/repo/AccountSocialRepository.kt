package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.account.data.AccountSocial
import org.teamfinder.data.account.keys.AccountSocialPK

interface AccountSocialRepository : JpaRepository<AccountSocial, AccountSocialPK>,
    JpaSpecificationExecutor<AccountSocial>