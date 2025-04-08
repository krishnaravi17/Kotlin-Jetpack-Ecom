package com.example.ecommerceuniqueapp.domain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceuniqueapp.data.api.NetworkResponse
import com.example.ecommerceuniqueapp.data.model.LoginModelRes
import com.example.ecommerceuniqueapp.data.model.ProductModelRes
import com.example.ecommerceuniqueapp.data.repository.LoginRepo
import com.example.ecommerceuniqueapp.data.repository.ProductRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepo) : ViewModel() {

    private val _productResult = MutableLiveData<NetworkResponse<List<ProductModelRes>>>()
    val productResult: LiveData<NetworkResponse<List<ProductModelRes>>> = _productResult

    init {
        //productList()
    }

    fun productList() {
        _productResult.value = NetworkResponse.Loading

        viewModelScope.launch {
            try {
                val response = repository.productList()
                Log.i("response ------", response.isSuccessful.toString())
                Log.i("response ------", response.message())
                Log.i("response ------", response.body().toString())
                if (response.isSuccessful) {
                    Log.i("response success", response.body().toString())
                    response.body()?.let {
                        _productResult.value = NetworkResponse.Success(it)
                    }
                } else {
                    Log.i("response failure", response.message())
                    Log.i("response failure", response.errorBody()?.source().toString())
                    _productResult.value = NetworkResponse.Failure(response.errorBody()?.source().toString())
                }

            } catch (e: Exception) {
                Log.i("response catch", e.toString())
                _productResult.value = NetworkResponse.Failure("Failed to Load Data! ${e.toString()}")
            }
        }

    }

    // >>>> >>>>> >>>>> >>>>> >>>> >>>> >>> >>>>> >>>>> >>>>> >>>>> >>>>> >>>> >>>>> >>>>

    private val _productByIdResult = MutableLiveData<NetworkResponse<ProductModelRes>>()
    val productByIdResult: LiveData<NetworkResponse<ProductModelRes>> = _productByIdResult

    fun getProductById(productId: String) {
        _productByIdResult.value = NetworkResponse.Loading

        viewModelScope.launch {
            try {
                val response = repository.getProductById(productId)
                Log.i("response ------", response.isSuccessful.toString())
                Log.i("response ------", response.message())
                Log.i("response ------", response.body().toString())
                if (response.isSuccessful) {
                    Log.i("response success", response.body().toString())
                    response.body()?.let {
                        _productByIdResult.value = NetworkResponse.Success(it)
                    }
                } else {
                    Log.i("response failure", response.message())
                    Log.i("response failure", response.errorBody()?.source().toString())
                    _productByIdResult.value = NetworkResponse.Failure(response.errorBody()?.source().toString())
                }

            } catch (e: Exception) {
                Log.i("response catch", e.toString())
                _productByIdResult.value = NetworkResponse.Failure("Failed to Load Data! ${e.toString()}")
            }
        }

    }
}