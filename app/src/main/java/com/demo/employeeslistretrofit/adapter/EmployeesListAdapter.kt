package com.demo.employeeslistretrofit.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.demo.employees.R
import com.demo.employeeslistretrofit.data.Data
import kotlinx.android.synthetic.main.employees_list_row.view.*


class EmployeesListAdapter(val activity: Activity): RecyclerView.Adapter<EmployeesListAdapter.MyViewHolder>() {

        private var employeesList: List<Data>? = null


    fun setEmployeesList(employeesList: List<Data>?) {
        this.employeesList = employeesList
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): EmployeesListAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.employees_list_row, parent, false)

        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: EmployeesListAdapter.MyViewHolder, position: Int) {
        holder.Email.text = employeesList!!.get(position).email
        holder.FirstName.text =employeesList!!.get(position).first_name + " "+ employeesList!!.get(position).last_name

        Glide.with(activity)
            .load(employeesList!!.get(position).avatar)
            .into(holder.Avatar)

    }

    override fun getItemCount(): Int
    {
        if(employeesList == null)return 0
        else return employeesList!!.size
    }

    class MyViewHolder(view : View): RecyclerView.ViewHolder(view){
        val Avatar = view.AvatarImage
        val FirstName = view.FirstName
        val Email = view.Email

      }}