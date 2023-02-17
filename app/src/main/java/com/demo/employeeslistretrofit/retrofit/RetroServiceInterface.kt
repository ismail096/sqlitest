package com.demo.employeeslistretrofit.retrofit

import com.demo.employeeslistretrofit.data.EmployeesModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInterface {

    @GET("users")
    fun getEmployees(@Query("page") page: String): Call<EmployeesModel>
}