package com.qi.kotlintest.fragments

import android.app.Fragment
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qi.kotlintest.R
import com.qi.kotlintest.adapters.EmployeeAdapter
import com.qi.kotlintest.models.EmployeeModel

/**
 * Created by Soumen on 11-09-2017.
 */
class FragmentD : Fragment() {

    lateinit var rclFakeList: RecyclerView
    lateinit var empList: ArrayList<EmployeeModel>

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater!!.inflate(R.layout.fragment_d, container, false)

        rclFakeList = view.findViewById(R.id.rclFakeList) as RecyclerView

        empList = ArrayList<EmployeeModel>()
        empList.add(EmployeeModel("1001", "Sam", "Tan", "3/A XYZ Square"))
        empList.add(EmployeeModel("1002", "Lam", "Gam", "17, Abc road"))
        empList.add(EmployeeModel("1003", "Yum", "Ham", "46, Ntt avenue"))
        empList.add(EmployeeModel("1004", "Tim", "Tam", "78, Hoboken, NJ"))

        rclFakeList.layoutManager = LinearLayoutManager(this@FragmentD.activity, LinearLayoutManager.VERTICAL, false)
        rclFakeList.adapter = EmployeeAdapter(this@FragmentD.activity, empList)

        return view
    }
}