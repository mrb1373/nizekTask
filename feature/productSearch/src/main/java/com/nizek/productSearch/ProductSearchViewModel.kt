package com.nizek.productSearch

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mrb.data.productSearch.ProductSearchRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductSearchViewModel @Inject constructor(
    private val productSearchRepository: ProductSearchRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow<ProductUiState>(ProductUiState.Loading)
    val uiState: StateFlow<ProductUiState> = _uiState
    private val searchQuery = MutableStateFlow("")

    init {
        viewModelScope.launch {
            searchApi()
        }
    }
    fun search(query: String) = viewModelScope.launch {
        _uiState.emit(ProductUiState.Loading)
        searchQuery.emit(query)
    }

    @OptIn(FlowPreview::class)
    private suspend fun searchApi() {
        searchQuery.debounce(100).collectLatest {
            if (it.isNotBlank() && it.isNotEmpty()) {
                productSearchRepository.searchProduct(it).apply {
                    onSuccess {
                        _uiState.emit(ProductUiState.Success(it.products))
                    }
                    onFailure {
                        _uiState.emit(ProductUiState.Error(it.message ?: "Unknown error"))
                    }
                }
            }
        }
    }
}