package org.teamfinder.api.helper.pagination

import org.springframework.stereotype.Component
import org.teamfinder.api.data.model.Pagination
import org.teamfinder.api.data.model.SortRule
import org.teamfinder.api.properties.PaginationProperties
import org.teamfinder.api.schema.dto.Pageable
import org.teamfinder.api.schema.dto.SortType
import org.teamfinder.api.schema.dto.Sort as SortDto

@Component
class PaginationHelper(
    private val properties: PaginationProperties
) {
    fun createPagination(pageable: Pageable?): Pagination =
        pageable?.let {
            Pagination(
                it.limit,
                it.offset.toLong(),
            )
        } ?: createDefaultPageable()

    fun <T> createSort(
        dto: SortDto?,
        sortVariants: Map<String, SortRule<T>>,
        defaultSort: SortRule<T>
    ): SortRule<T> {
        if (dto == null) {
            return defaultSort
        }

        val selectedSortVariant = sortVariants[dto.name]
            ?: return defaultSort

        selectedSortVariant.isAscending = (dto.type == SortType.ASC)

        return selectedSortVariant
    }

    private fun createDefaultPageable(): Pagination =
        Pagination(
            properties.defaultLimit,
            properties.defaultOffset,
        )
}
