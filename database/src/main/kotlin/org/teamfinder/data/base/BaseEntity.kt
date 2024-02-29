package org.teamfinder.data.base

import jakarta.persistence.*
import org.springframework.data.util.ProxyUtils

@MappedSuperclass
abstract class BaseEntity<T> {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var pk: T? = null

    val id: T
        get() = pk!!

    override fun equals(other: Any?): Boolean {
        other ?: return false

        if (this === other) return true

        if (javaClass != ProxyUtils.getUserClass(other)) return false

        other as BaseEntity<*>

        return this.pk != null && this.pk == other.pk
    }

    override fun hashCode(): Int {
        return pk?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "${this.javaClass.simpleName}(id=$pk)"
    }
}