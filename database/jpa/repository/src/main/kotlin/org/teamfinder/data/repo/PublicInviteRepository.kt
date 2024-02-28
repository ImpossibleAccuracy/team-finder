package org.teamfinder.data.repo

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.teamfinder.data.account.flow.PublicInvite
import org.teamfinder.data.account.keys.PublicInvitePK

interface PublicInviteRepository : JpaRepository<PublicInvite, PublicInvitePK>, JpaSpecificationExecutor<PublicInvite>