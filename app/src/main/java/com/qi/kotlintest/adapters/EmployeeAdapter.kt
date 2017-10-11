package com.qi.kotlintest.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import com.qi.kotlintest.models.EmployeeModel
import android.view.ViewGroup
import com.qi.kotlintest.R
import com.qi.kotlintest.viewholders.EmployeeViewHolder

/**
 * Created by Soumen on 11-09-2017.
 */
class EmployeeAdapter(val context: Context, val empList: ArrayList<EmployeeModel>)
        : RecyclerView.Adapter<EmployeeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): com.qi.kotlintest.viewholders.EmployeeViewHolder? {
        var inflater = LayoutInflater.from(context)
        var view = inflater!!.inflate(R.layout.list_item_employee, parent, false)
        return EmployeeViewHolder(view)
    }

    override fun onBindViewHolder(holder: com.qi.kotlintest.viewholders.EmployeeViewHolder?, position: Int) {
        holder!!.getTxtId().text = empList.get(position).id
        holder!!.getTxtName().text = empList.get(position).fname + " " + empList.get(position).lname
        holder!!.getTxtaddress().text = empList.get(position).address
    }

    override fun getItemCount(): Int {
        return empList!!.size
    }

    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }
}