package org.teamfinder.data.team

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity
import org.teamfinder.data.game.Game
import org.teamfinder.data.team.meta.TeamStatus
import org.teamfinder.data.team.meta.TeamType

@Entity
class Team(
    @Column(name = "Title", nullable = false)
    var title: String,

    @Column(name = "D", nullable = false, columnDefinition = "text")
    var description: String,

    @Column(name = "TotalPersonAmount")
    var totalPersonAmount: Int?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID", nullable = false)
    var creator: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeID", nullable = false)
    var type: TeamType,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "StatusID", nullable = false)
    var status: TeamStatus,

    @ManyToMany
    @JoinTable(
        name = "TeamGame",
        joinColumns = [JoinColumn(name = "TeamId")],
        inverseJoinColumns = [JoinColumn(name = "GameId")]
    )
    var teamGameGames: Set<Game> = HashSet(),
) : BaseAuditEntity<Long>()
