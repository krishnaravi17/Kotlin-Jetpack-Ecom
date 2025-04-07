package com.example.ecommerceuniqueapp.data.api

import com.example.ecommerceuniqueapp.data.model.LoginModelRes
import com.example.ecommerceuniqueapp.data.model.ProductModelRes
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query


interface ApiService {

    /*@POST("/auth/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): Response<LoginModelRes>*/

    @Headers("Content-Type: application/json")
    @POST("/auth/login")
    suspend fun login(@Body body: LoginModelRes) : Response<LoginModelRes>

    @Headers("Content-Type: application/json")
    @GET("/products")
    suspend fun productList() : Response<List<ProductModelRes>>


}