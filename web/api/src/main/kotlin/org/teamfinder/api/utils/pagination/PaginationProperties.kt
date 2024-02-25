package org.teamfinder.api.utils.pagination

import jakarta.validation.constraints.Min
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.validation.annotation.Validated

@Validated
@ConfigurationProperties(prefix = "app.pagination")
class PaginationProperties(
    @Min(0)
    val defaultOffset: Long = 0,
    @Min(1)
    val defaultLimit: Int,
)
