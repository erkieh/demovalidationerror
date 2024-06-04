package com.deserializenull.rest

import com.deserializenull.rest.dto.ParentDto
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import jakarta.validation.Valid

@Validated
@Controller("/")
class NonNullDtoController(
) {

    @Post("parentDto")
    fun postParentDto(@Valid @Body request: ParentDto): ParentDto {
        return request
    }
}