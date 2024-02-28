package org.teamfinder.data.common.media

import jakarta.persistence.*
import org.teamfinder.data.base.BaseEntity
import org.teamfinder.data.common.file.LocalFile

@Entity
class MediaCollectionItem(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MediaCollectionID", nullable = false)
    var mediaCollection: MediaCollection,

    @Column(name = "order", nullable = false)
    var order: Int,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "InternalID")
    var internal: LocalFile?,

    @Column(name = "ExternalPath", nullable = false)
    var externalPath: String?,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExternalTypeID")
    var externalType: MediaItemExternalType?,
) : BaseEntity<Long>()
