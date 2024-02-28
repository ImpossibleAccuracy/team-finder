package org.teamfinder.data.channel

import jakarta.persistence.*
import org.teamfinder.data.base.BaseAuditEntity
import org.teamfinder.data.channel.meta.ChannelAdmissionPolicy
import org.teamfinder.data.channel.meta.ChannelCategory
import org.teamfinder.data.channel.meta.ChannelVisibility
import org.teamfinder.data.game.Game

@Entity
class Channel(
    @Column(name = "Title", nullable = false)
    var title: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CategoryID", nullable = false)
    var category: ChannelCategory,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VisibilityID", nullable = false)
    var visibility: ChannelVisibility,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AdmissionPolicyID", nullable = false)
    var admissionPolicy: ChannelAdmissionPolicy,

    @OneToMany(mappedBy = "id")
    @PrimaryKeyJoinColumn
    var info: ChannelInfo,

    @ManyToMany
    @JoinTable(
        name = "ChannelGame",
        joinColumns = [JoinColumn(name = "ChannelId")],
        inverseJoinColumns = [JoinColumn(name = "GameId")]
    )
    var channelGames: Set<Game> = HashSet(),
) : BaseAuditEntity<Long>()
