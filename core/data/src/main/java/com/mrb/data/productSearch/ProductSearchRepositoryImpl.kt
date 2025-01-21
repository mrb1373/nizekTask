package com.mrb.data.productSearch

import com.nizek.common.suspendRunCatching
import com.nizek.network.api.ProductSearchService
import com.nizek.network.data.ProductSearch
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject

class ProductSearchRepositoryImpl @Inject constructor(
    private val productSearchService: ProductSearchService
): ProductSearchRepository {
    override suspend fun searchProduct(query: String): Result<ProductSearch> = coroutineScope {
        suspendRunCatching {
            productSearchService.searchService(query)
        }
    }
}