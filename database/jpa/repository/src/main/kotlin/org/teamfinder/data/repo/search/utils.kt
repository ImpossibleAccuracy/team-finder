package org.teamfinder.data.repo.search

import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.Path
import jakarta.persistence.criteria.Predicate
import org.springframework.data.jpa.domain.Specification

fun <T> createDefaultSpec(): Specification<T> =
    Specification<T> { _, _, _ -> null }

fun <T> specificationsList(vararg items: Specification<T>?): Specification<T> {
    val specifications = items.filterNotNull()

    if (specifications.size <= 1) {
        return specifications.first()
    }

    return Specification.allOf(specifications)
}

fun CriteriaBuilder.likeIgnoreCase(root: Path<String>, data: String): Predicate =
    like(
        lower(root),
        "%$data%".lowercase()
    )

fun <T> Specification<T>.combineIf(expression: Boolean, func: () -> Specification<T>): Specification<T> =
    if (expression) {
        and(func())
    } else {
        this
    }
