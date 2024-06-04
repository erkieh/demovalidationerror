package com.deserializenull

import io.micronaut.context.annotation.Replaces
import io.micronaut.core.annotation.NonNull
import io.micronaut.http.server.exceptions.response.ErrorContext
import io.micronaut.problem.ProblemErrorResponseProcessor
import io.micronaut.problem.conf.ProblemConfiguration
import jakarta.inject.Singleton

@Replaces(ProblemErrorResponseProcessor::class)
@Singleton
class ProblemErrorResponseProcessorReplacement internal constructor(config: ProblemConfiguration?) :
    ProblemErrorResponseProcessor(config) {
    override fun includeErrorMessage(@NonNull errorContext: ErrorContext): Boolean {
        return true
    }
}