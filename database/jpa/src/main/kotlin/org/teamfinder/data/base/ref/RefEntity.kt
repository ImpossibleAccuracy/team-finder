package org.teamfinder.data.base.ref

import jakarta.persistence.EmbeddedId
import jakarta.persistence.MappedSuperclass
import org.springframework.data.util.ProxyUtils

@MappedSuperclass
abstract class RefEntity<T> {
    @EmbeddedId
    var pk: T? = null

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as RefEntity<*>

        return this.pk != null && this.pk == other.pk
    }

    override fun hashCode(): Int {
        return pk?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName}(id=$pk)"
    }
}
