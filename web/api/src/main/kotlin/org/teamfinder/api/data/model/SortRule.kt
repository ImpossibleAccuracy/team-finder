package org.teamfinder.api.data.model

import org.springframework.data.domain.Sort

data class SortRule<T>(val sort: Sort) {
    var isAscending: Boolean = true
}
