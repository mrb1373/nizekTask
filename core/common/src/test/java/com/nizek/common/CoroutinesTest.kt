package com.nizek.common

import android.util.Log
import io.mockk.every
import io.mockk.mockkStatic
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class CoroutinesTest {
    @Test
    fun suspendRunCatching_shouldReturnSuccess_whenBlockExecutesSuccessfully() = runTest {
        // When
        val result = suspendRunCatching { 1 }

        // Then
        assertEquals(result.isSuccess, true)
        assertEquals(result.getOrThrow() , 1)
    }

    @Test
    fun suspendRunCatching_shouldReturnFailure_whenBlockThrowsException() = runTest {
        // Given
        val exception = Exception("Some exception")
        mockkStatic(Log::class)

        every { Log.i(any(), any(), any()) } returns 0

        // When
        val result = suspendRunCatching { throw exception }

        // Then
        assertEquals(result.isFailure, true)
        assertEquals(result.exceptionOrNull(), exception)
    }
}