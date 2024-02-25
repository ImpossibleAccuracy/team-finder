package org.teamfinder.api.utils.datetime

import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneOffset
import java.util.*

fun Date.toLocalDate(): LocalDate = LocalDate.ofInstant(
    Instant.ofEpochMilli(time),
    ZoneOffset.systemDefault()
)

fun Instant.toLocalDate(): LocalDate = LocalDate.ofInstant(this, ZoneOffset.UTC)

fun Instant.toLocalDateTime(): LocalDateTime = LocalDateTime.ofInstant(this, ZoneOffset.UTC)

fun LocalDateTime.toInstant(): Instant = toInstant(ZoneOffset.UTC)

fun LocalDate.toInstant(): Instant = atStartOfDay().toInstant()
