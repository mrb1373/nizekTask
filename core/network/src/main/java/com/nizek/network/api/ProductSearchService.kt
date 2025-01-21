package com.nizek.network.api

import com.nizek.network.data.ProductSearch
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductSearchService {
    @GET("products/")
    suspend fun searchService(@Query("search") query: String): ProductSearch
}