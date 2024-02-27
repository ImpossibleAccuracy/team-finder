package org.teamfinder.data.team.request

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.team.Team
import java.time.OffsetDateTime

@Entity
class TeamRequest(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    @SequenceGenerator(
        name = "primary_sequence",
        sequenceName = "primary_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    var id: Long,

    @Column(name = "CreatedAt", nullable = false)
    var createdAt: OffsetDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AccountID", nullable = false)
    var account: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TeamID", nullable = false)
    var team: Team,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StatusID", nullable = false)
    var status: TeamRequestStatus,
)
