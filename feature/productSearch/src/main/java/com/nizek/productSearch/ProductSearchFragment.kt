package com.nizek.productSearch

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ProgressBar
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.progressindicator.CircularProgressIndicator
import com.nizek.common.hide
import com.nizek.common.show
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductSearchFragment : Fragment() {
    private val viewModel: ProductSearchViewModel by viewModels()
    private val TAG = "ProductSearchFragment"
    lateinit var searchField: EditText
    lateinit var recyclerView: RecyclerView
    lateinit var progressIndicator: ProgressBar
    private lateinit var productAdapter: ProductSearchAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.product_search_layout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        handleSearch()
        productAdapter = ProductSearchAdapter()
        searchField = view.findViewById(R.id.searchField)
        recyclerView = view.findViewById(R.id.productList)
        recyclerView.adapter = productAdapter
        progressIndicator = view.findViewById(R.id.progressIndicator)
        searchField.doOnTextChanged { text, _, _, _ ->
            viewModel.search(text.toString())
        }
    }

    private fun handleSearch() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.uiState.collect {
                    when(it) {
                        is ProductUiState.Loading -> {
                            progressIndicator.show()
                        }
                        is ProductUiState.Error -> {
                            progressIndicator.hide()
                            Log.e(TAG, "handleSearch: ${it.message}")
                        }
                        is ProductUiState.Success -> {
                            progressIndicator.hide()
                            Log.d(TAG, "handleSearch: ${it.list}")
                            productAdapter.submitList(it.list)
                        }

                        ProductUiState.Idle -> {
                            progressIndicator.hide()
                            productAdapter.submitList(emptyList())
                        }
                    }
                }
            }
        }
    }
}