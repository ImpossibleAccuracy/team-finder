package org.teamfinder.data.game

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity
import org.teamfinder.data.common.media.MediaCollection

@Entity
class Game(
    @Column(name = "Title", nullable = false)
    var title: String,

    @Column(name = "Description", nullable = false, columnDefinition = "text")
    var description: String,

    @Column(name = "CreatorStudioName", nullable = false)
    var creatorStudioName: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID", nullable = false)
    var creator: Account,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MediaCollectionID", nullable = false)
    var mediaCollection: MediaCollection,

    @Column(name = "Validated", nullable = false)
    var validated: Boolean,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ValidatedBy")
    var validatedBy: Account,
) : BaseAuditEntity<Long>()
