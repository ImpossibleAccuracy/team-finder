package org.teamfinder.data.channel

import jakarta.persistence.*
import org.teamfinder.data.base.BaseEntity
import org.teamfinder.data.channel.meta.ChannelAdmissionPolicy
import org.teamfinder.data.channel.meta.ChannelCategory
import org.teamfinder.data.channel.meta.ChannelVisibility

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

    @OneToOne(mappedBy = "channel")
    @PrimaryKeyJoinColumn
    var info: ChannelInfo,

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//        name = "ChannelGame",
//        joinColumns = [JoinColumn(name = "ChannelId")],
//        inverseJoinColumns = [JoinColumn(name = "GameId")]
//    )
//    var channelGames: List<Game> = listOf(),
) : BaseEntity<Long>()
