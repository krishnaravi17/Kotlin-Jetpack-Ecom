package com.example.ecommerceuniqueapp.data.repository

import com.example.ecommerceuniqueapp.data.api.ApiService
import com.example.ecommerceuniqueapp.data.model.LoginModelRes
import retrofit2.Response
import javax.inject.Inject

class LoginRepo @Inject constructor(private val apiService: ApiService) {

    suspend fun login(username: String, password: String):
            Response<LoginModelRes> {
        return apiService.login(LoginModelRes(username = username, password = password, token = ""))
    }
}