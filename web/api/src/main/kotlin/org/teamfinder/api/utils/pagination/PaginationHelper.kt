package org.teamfinder.api.utils.pagination

import com.powerplace.api.schema.dto.Pagination
import com.powerplace.api.schema.dto.SortType
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import com.powerplace.api.schema.dto.Sort as SortDto

@Service
class PaginationHelper(
    private val properties: PaginationProperties
) {
    fun getSort(
        inputSort: SortDto?,
        sortVariants: Map<String, Sort>,
        defaultSort: Sort = Sort.by(Sort.Direction.DESC, "id")
    ): Sort {
        if (inputSort == null) {
            return defaultSort
        }

        val selectedSortVariant = sortVariants[inputSort.name]
            ?: return defaultSort

        return when (inputSort.type) {
            null -> {
                selectedSortVariant
            }

            SortType.ASC -> {
                selectedSortVariant.ascending()
            }

            SortType.DESC -> {
                selectedSortVariant.descending()
            }
        }
    }

    fun createDefaultPageable(sort: Sort = Sort.by(Sort.Direction.DESC, "id")): Pageable =
        OffsetBasedPageRequest(
            properties.defaultOffset,
            properties.defaultLimit,
            sort
        )

    fun createPageable(
        pagination: Pagination?,
        sortVariants: Map<String, Sort>,
        defaultSort: Sort = Sort.by(Sort.Direction.DESC, "id")
    ): Pageable =
        pagination?.let {
            OffsetBasedPageRequest(
                pagination.offset.toLong(),
                pagination.limit,
                getSort(pagination.sort, sortVariants, defaultSort)
            )
        } ?: createDefaultPageable(defaultSort)
}
