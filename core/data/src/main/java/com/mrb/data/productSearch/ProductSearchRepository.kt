package com.mrb.data.productSearch

import com.nizek.network.data.ProductSearch

interface ProductSearchRepository {
    suspend fun searchProduct(query: String): Result<ProductSearch>
}