package org.teamfinder.data.game.gennre

import jakarta.persistence.Column
import jakarta.persistence.Entity
import org.teamfinder.data.base.BaseEntity

@Entity
class Genre(
    @Column(name = "Title", nullable = false)
    var title: String,
) : BaseEntity<Long>()
