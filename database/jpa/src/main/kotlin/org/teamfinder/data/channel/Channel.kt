package org.teamfinder.data.channel

import jakarta.persistence.*
import org.teamfinder.data.channel.meta.ChannelAdmissionPolicy
import org.teamfinder.data.channel.meta.ChannelCategory
import org.teamfinder.data.channel.meta.ChannelVisibility
import org.teamfinder.data.game.Game

@Entity
class Channel(
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
)
