package org.teamfinder.data.common.media

import jakarta.persistence.*
import org.teamfinder.data.common.file.LocalFile

@Entity
class MediaCollectionItem(
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
)
