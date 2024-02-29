package org.teamfinder.api.data.utils

import org.springframework.data.domain.Pageable
import org.teamfinder.api.data.model.Pagination
import org.teamfinder.api.data.model.SortRule
import org.teamfinder.api.helper.pagination.OffsetBasedPageRequest

fun <T> Pagination.toPageable(sort: SortRule<T>): Pageable {
    val actualSort = if (sort.isAscending) {
        sort.sort.ascending()
    } else {
        sort.sort.descending()
    }

    return OffsetBasedPageRequest(
        offset = offset,
        limit = limit,
        sort = actualSort
    )
}
