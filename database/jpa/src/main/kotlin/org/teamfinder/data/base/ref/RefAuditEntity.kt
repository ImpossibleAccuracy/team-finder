package org.teamfinder.data.base.ref

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.teamfinder.data.base.BaseAuditEntity
import java.time.LocalDateTime

@MappedSuperclass
abstract class RefAuditEntity<T> : RefEntity<T>() {
    @Column(name = "CreatedAt", nullable = false)
    var createdAt: LocalDateTime = LocalDateTime.now()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as BaseAuditEntity<*>

        return createdAt == other.createdAt
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + createdAt.hashCode()
        return result
    }
}
