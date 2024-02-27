package org.teamfinder.data.common.content

import jakarta.persistence.*

@Entity
class ContentItemType (
    @Id
    @Column(name = "createdAt", nullable = false, updatable = false)
    @SequenceGenerator(
        name = "primary_sequence",
        sequenceName = "primary_sequence",
        allocationSize = 1,
        initialValue = 1
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_sequence")
    var id: Long,

    @Column(name = "createdAt", nullable = false)
    var title: String,
)
