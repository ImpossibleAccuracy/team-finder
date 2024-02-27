package org.teamfinder.data.common.media

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import java.time.OffsetDateTime

@Entity
class MediaCollection(
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

    @Column(name = "CreatedAt", nullable = false)
    var createdAt: OffsetDateTime,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID", nullable = false)
    var creator: Account,

    @OneToMany(mappedBy = "mediaCollection")
    var items: Set<MediaCollectionItem> = HashSet(),
)
