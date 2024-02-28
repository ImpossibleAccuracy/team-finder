package org.teamfinder.data.social

import jakarta.persistence.*
import org.teamfinder.data.base.BaseAuditEntity
import org.teamfinder.data.common.file.LocalFile

@Entity
class Social(
    @Column(name = "Title", nullable = false)
    var title: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "LogoID")
    var logo: LocalFile?,
) : BaseAuditEntity<Long>()
