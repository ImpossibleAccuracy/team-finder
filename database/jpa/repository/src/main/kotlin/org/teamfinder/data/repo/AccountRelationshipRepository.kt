package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.account.data.AccountRelationship
import org.teamfinder.data.account.keys.AccountRelationshipPK

interface AccountRelationshipRepository : JpaRepository<AccountRelationship, AccountRelationshipPK>,
    JpaSpecificationExecutor<AccountRelationship>