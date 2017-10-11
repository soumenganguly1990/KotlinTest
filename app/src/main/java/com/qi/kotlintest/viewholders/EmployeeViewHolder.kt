package com.qi.kotlintest.viewholders

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.qi.kotlintest.R

/**
 * Created by Soumen on 12-09-2017.
 */
class EmployeeViewHolder (view: View) :  RecyclerView.ViewHolder(view) {

    private lateinit var txtId: TextView
    private lateinit var txtName: TextView
    private lateinit var txtAddress: TextView

    init {
        txtId = view.findViewById(R.id.txtId) as TextView
        txtName = view.findViewById(R.id.txtName) as TextView
        txtAddress = view.findViewById(R.id.txtAddress) as TextView
    }

    fun getTxtId(): TextView {
        return txtId
    }

    fun getTxtName(): TextView {
        return txtName
    }

    fun getTxtaddress(): TextView {
        return txtAddress
    }
}