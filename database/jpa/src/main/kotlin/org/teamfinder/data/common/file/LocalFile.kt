package org.teamfinder.data.common.file

import jakarta.persistence.*
import java.time.OffsetDateTime

@Entity
class LocalFile(
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

    @Column(name = "Path", nullable = false)
    var path: String,

    @Column(name = "Hash", nullable = false)
    var hash: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TypeID", nullable = false)
    var type: LocalFileType,
)
