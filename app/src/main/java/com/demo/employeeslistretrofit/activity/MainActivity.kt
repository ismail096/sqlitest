package com.demo.employeeslistretrofit.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.demo.employees.R
import com.demo.employeeslistretrofit.adapter.EmployeesListAdapter
import com.demo.employeeslistretrofit.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var recyclerAdapter: EmployeesListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
        initViewModel()
    }

    private fun initRecyclerView() {
        employeesListRecyclerview.layoutManager = LinearLayoutManager(this)
        recyclerAdapter = EmployeesListAdapter(this)
        employeesListRecyclerview.adapter =recyclerAdapter

    }

    private fun initViewModel() {
        val viewModel:MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        viewModel.getLiveDataObserver().observe(this, Observer {
            if(it != null) {
                recyclerAdapter.setEmployeesList(it.data)
                recyclerAdapter.notifyDataSetChanged()
            } else {
                Toast.makeText(this, "Erreur", Toast.LENGTH_SHORT).show()
            }
        })
        viewModel.makeAPICall()
    }
}