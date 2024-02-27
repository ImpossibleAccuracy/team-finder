package org.teamfinder.data.channel.keys

import jakarta.persistence.Column
import jakarta.persistence.Embeddable

@Embeddable
data class ChannelSocialPK(
    @Column(name = "ChannelID", nullable = false)
    val channelId: Long,
    @Column(name = "SocialID", nullable = false)
    val socialId: Long
)
