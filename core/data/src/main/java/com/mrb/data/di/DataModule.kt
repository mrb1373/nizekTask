package com.mrb.data.di

import com.mrb.data.productSearch.ProductSearchRepository
import com.mrb.data.productSearch.ProductSearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindsProductSearchRepository(
        productSearchRepositoryImpl: ProductSearchRepositoryImpl
    ): ProductSearchRepository
}