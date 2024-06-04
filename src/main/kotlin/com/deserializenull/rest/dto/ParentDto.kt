package com.deserializenull.rest.dto

import io.micronaut.serde.annotation.Serdeable
import jakarta.validation.Valid
import jakarta.validation.constraints.NotNull

@Serdeable
data class ParentDto(
    @field:Valid
    val childDto: ChildDto,
)