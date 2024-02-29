package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.account.data.AccountSubscriber
import org.teamfinder.data.account.keys.AccountSubscriberPK

interface AccountSubscriberRepository : JpaRepository<AccountSubscriber, AccountSubscriberPK>,
    JpaSpecificationExecutor<AccountSubscriber>