package org.teamfinder.data.common.media

import jakarta.persistence.*
import org.teamfinder.data.account.Account
import org.teamfinder.data.base.BaseAuditEntity

@Entity
class MediaCollection(
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CreatorID", nullable = false)
    var creator: Account,

    @OneToMany(mappedBy = "mediaCollection")
    var items: Set<MediaCollectionItem> = HashSet(),
) : BaseAuditEntity<Long>()
