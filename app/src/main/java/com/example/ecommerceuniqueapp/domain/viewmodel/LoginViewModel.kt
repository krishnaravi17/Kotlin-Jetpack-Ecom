package com.example.ecommerceuniqueapp.domain.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerceuniqueapp.data.api.NetworkResponse
import com.example.ecommerceuniqueapp.data.model.LoginModelRes
import com.example.ecommerceuniqueapp.data.repository.LoginRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepo) : ViewModel() {

    private val _loginResult = MutableLiveData<NetworkResponse<LoginModelRes>>()
    val loginResult: LiveData<NetworkResponse<LoginModelRes>> = _loginResult

    fun login(username: String, password: String) {
        _loginResult.value = NetworkResponse.Loading

        viewModelScope.launch {
            try {
                val response = repository.login(username, password)
                Log.i("response ------", response.isSuccessful.toString())
                Log.i("response ------", response.message())
                Log.i("response ------", response.body().toString())
                if (response.isSuccessful) {
                    Log.i("response success", response.body().toString())
                    response.body()?.let {
                        _loginResult.value = NetworkResponse.Success(it)
                    }
                } else {
                    Log.i("response failure", response.message())
                    Log.i("response failure", response.errorBody()?.source().toString())
                    _loginResult.value = NetworkResponse.Failure(response.errorBody()?.source().toString())
                }

            } catch (e: Exception) {
                Log.i("response catch", e.toString())
                _loginResult.value = NetworkResponse.Failure("Failed to Load Data! ${e.toString()}")
            }
        }

    }
}