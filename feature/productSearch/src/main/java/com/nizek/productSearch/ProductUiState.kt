package com.nizek.productSearch

import com.nizek.network.data.Product

sealed class ProductUiState {
    data object Loading : ProductUiState()
    data class Success(val list: List<Product>) : ProductUiState()
    data class Error(val message: String) : ProductUiState()
}