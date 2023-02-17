package com.demo.employeeslistretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.demo.employeeslistretrofit.data.EmployeesModel
import com.demo.employeeslistretrofit.retrofit.RetroInstance
import com.demo.employeeslistretrofit.retrofit.RetroServiceInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivityViewModel: ViewModel() {

    lateinit var liveDataList: MutableLiveData<EmployeesModel>

    init {
        liveDataList = MutableLiveData()
    }


    fun getLiveDataObserver(): MutableLiveData<EmployeesModel> {
        return liveDataList
    }

    fun makeAPICall() {
        val retroInstance = RetroInstance.getRetroInstance()
        val retroService  = retroInstance.create(RetroServiceInterface::class.java)
        val call  = retroService.getEmployees("1")
        call.enqueue(object : Callback<EmployeesModel> {
            override fun onFailure(call: Call<EmployeesModel>, t: Throwable) {
                liveDataList.postValue(null)
            }

            override fun onResponse(
                call: Call<EmployeesModel>,
                response: Response<EmployeesModel>
            ) {
                liveDataList.postValue(response.body())
            }
        })


    }
}