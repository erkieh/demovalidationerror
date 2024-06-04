package com.deserializenull.rest

import com.deserializenull.rest.dto.ParentDto
import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.runtime.EmbeddedApplication
import io.micronaut.test.extensions.kotest5.annotation.MicronautTest

@MicronautTest
class NonNullDtoControllerTest(private val application: EmbeddedApplication<*>, @Client("/") httpClient: HttpClient) : StringSpec({

    "test the server is running" {
        assert(application.isRunning)
    }

    "test response should contain nested field path" {
        // when
        val e = shouldThrow<HttpClientResponseException> {
            httpClient.toBlocking().exchange(HttpRequest.POST("parentDto", "{\"childDto\":{}}"), ParentDto::class.java)
        }

        // then
        assertSoftly {
            e.status shouldBe HttpStatus.BAD_REQUEST
            e.message shouldContain "childDto"
            e.message shouldContain "stringField"
        }
    }
})
