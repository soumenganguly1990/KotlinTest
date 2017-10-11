package com.qi.kotlintest.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.qi.kotlintest.R
import com.qi.kotlintest.common.ButtonClickedListener

/**
 * Created by Soumen on 12-09-2017.
 */
class MiddleFragment: Fragment(), ButtonClickedListener {

    lateinit var txtMiddleFrag: TextView

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.fragment_middle, container, false)
        txtMiddleFrag = view.findViewById(R.id.txtMiddleFrag) as TextView
        return view
    }

    override fun onButtonClicked(value: String) {
        txtMiddleFrag!!.text = value
    }
}