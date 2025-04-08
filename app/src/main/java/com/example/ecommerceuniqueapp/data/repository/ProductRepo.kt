package com.example.ecommerceuniqueapp.data.repository

import androidx.compose.ui.graphics.drawscope.Stroke
import com.example.ecommerceuniqueapp.data.api.ApiService
import com.example.ecommerceuniqueapp.data.model.LoginModelRes
import com.example.ecommerceuniqueapp.data.model.ProductModelRes
import retrofit2.Response
import javax.inject.Inject

class ProductRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun productList(): Response<List<ProductModelRes>> {
        return apiService.productList()
    }

    suspend fun getProductById(id: String): Response<ProductModelRes> {
        return apiService.getProductById(id)
    }
}