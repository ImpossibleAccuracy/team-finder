package org.teamfinder.data.base

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass

@MappedSuperclass
abstract class BaseKeyEntity<T> : BaseEntity<T>() {
    @Column(name = "Title", nullable = false)
    var title: String = ""

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as BaseKeyEntity<*>

        return title == other.title
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + title.hashCode()
        return result
    }
}
