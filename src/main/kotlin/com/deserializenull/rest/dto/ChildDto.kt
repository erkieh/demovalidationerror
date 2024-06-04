package com.deserializenull.rest.dto

import io.micronaut.serde.annotation.Serdeable

@Serdeable
data class ChildDto(
    val stringField: String
)