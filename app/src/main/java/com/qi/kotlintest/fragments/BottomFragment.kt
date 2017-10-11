package com.qi.kotlintest.fragments

import android.app.Fragment
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.qi.kotlintest.R
import com.qi.kotlintest.common.ButtonClickedListener
import com.qi.kotlintest.common.TextChangedListener

/**
 * Created by IN-LT-51 on 12-09-2017.
 */
class BottomFragment: Fragment(), TextChangedListener {

    lateinit var btnBottomFrag: Button
    lateinit var buttonClickedListener: ButtonClickedListener
    lateinit var value: String

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater!!.inflate(R.layout.fragment_bottom, container, false)
        btnBottomFrag = view.findViewById(R.id.btnBottomFrag) as Button

        btnBottomFrag.setOnClickListener(View.OnClickListener {
            buttonClickedListener.onButtonClicked(value)
        })

        return view;
    }

    fun setButtonClickedCallback(buttonClickedListener: ButtonClickedListener) {
        this.buttonClickedListener = buttonClickedListener
    }

    override fun onTextChanged(value: String) {
        this.value = value
    }
}