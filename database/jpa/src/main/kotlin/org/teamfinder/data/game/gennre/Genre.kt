package org.teamfinder.data.game.gennre

import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.teamfinder.data.base.BaseAuditEntity

@Entity
class Genre(
    @Column(name = "createdAt", nullable = false)
    var title: String,
) : BaseAuditEntity<Long>()
