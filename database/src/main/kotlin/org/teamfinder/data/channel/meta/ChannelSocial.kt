package org.teamfinder.data.channel.meta

import jakarta.persistence.*
import org.teamfinder.data.base.ref.RefEntity
import org.teamfinder.data.channel.Channel
import org.teamfinder.data.channel.keys.ChannelSocialPK
import org.teamfinder.data.social.Social

@Entity(name = "Channel_Social")
class ChannelSocial(
    @MapsId("channelId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "channelID", nullable = false)
    var channel: Channel,

    @MapsId("socialId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "socialID", nullable = false)
    var social: Social,

    @Column(name = "Value", nullable = false)
    var value: String,
) : RefEntity<ChannelSocialPK>()
