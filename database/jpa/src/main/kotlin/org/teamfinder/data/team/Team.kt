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

    @Column(name = "Description", nullable = false, columnDefinition = "text")
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
) : BaseAuditEntity<Long>() {
    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Game::class)
    @JoinTable(
        name = "Team_Game",
        joinColumns = [JoinColumn(name = "TeamID")],
        inverseJoinColumns = [JoinColumn(name = "GameID")]
    )
    var teamGames: List<Game> = listOf()
}
