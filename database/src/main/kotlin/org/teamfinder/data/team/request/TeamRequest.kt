package org.teamfinder.data.team.request

import jakarta.persistence.Entity
import jakarta.persistence.FetchType
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity
import org.teamfinder.data.team.Team

@Entity
class TeamRequest(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TeamID", nullable = false)
    var team: Team,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StatusID", nullable = false)
    var status: TeamRequestStatus,
) : BaseAuditEntity<Long>()
