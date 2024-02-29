package org.teamfinder.data.common.file

import jakarta.persistence.*
import org.teamfinder.data.base.BaseAuditEntity

@Entity(name = "File")
class LocalFile(
    @Column(name = "Path", nullable = false)
    var path: String,

    @Column(name = "Hash", nullable = false)
    var hash: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Type", nullable = false)
    var type: LocalFileType,
) : BaseAuditEntity<Long>()
