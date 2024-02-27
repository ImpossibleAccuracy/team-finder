package org.teamfinder.data.common.content.variant

import jakarta.persistence.*
import org.teamfinder.data.common.content.ContentItem

@Entity
class ContentItemText(
    @Id
    @Column(name = "ID", nullable = false, updatable = false)
    var id: Long,

    @Column(name = "CreatedAt", nullable = false, columnDefinition = "text")
    var text: String,

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID", nullable = false)
    var contentItem: ContentItem,
)
