package com.nizek.network

import com.nizek.network.api.ProductSearchService
import com.nizek.network.data.Product
import com.nizek.network.data.ProductSearch
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class ProductSearchServiceTest {

    @Test
    fun `searchService returns expected data`() = runBlocking {
        // Mock the ProductSearchService
        val mockService = mockk<ProductSearchService>()

        // Mocked response
        val mockResponse = ProductSearch(
            products = listOf(
                Product(id = 1, title = "Product 1", images = listOf("image1.jpg", "image2.jpg"), thumbnail = "thumbnail1.jpg"),
                Product(id = 2, title = "Product 2", images = listOf("image1.jpg", "image2.jpg"), thumbnail = "thumbnail1.jpg")
            ),
            total = 2
        )

        // Stub the method
        coEvery { mockService.searchService("product") } returns mockResponse

        // Call the mocked service
        val response = mockService.searchService("product")

        // Verify the response
        assertEquals(2, response.products.size)
        assertEquals("Product 1", response.products[0].title)
        assertEquals("Product 2", response.products[1].title)
    }
}