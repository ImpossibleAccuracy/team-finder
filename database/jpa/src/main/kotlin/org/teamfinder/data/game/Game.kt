package org.teamfinder.data.game

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity
import org.teamfinder.data.common.media.MediaCollection

@Entity
class Game(
    @Column(name = "createdAt", nullable = false)
    var title: String,

    @Column(name = "createdAt", nullable = false, columnDefinition = "text")
    var description: String,

    @Column(name = "createdAt", nullable = false)
    var creatorStudioName: String,

    @Column(name = "createdAt", nullable = false)
    var validated: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "creatorID", nullable = false)
    var creator: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "media_collectionID", nullable = false)
    var mediaCollection: MediaCollection,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "validated_byID")
    var validatedBy: Account,
) : BaseAuditEntity<Long>()
