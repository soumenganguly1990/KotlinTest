package com.qi.kotlintest.fragments

import android.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.qi.kotlintest.R
import com.qi.kotlintest.common.TextChangedListener

/**
 * Created by Soumen on 12-09-2017.
 */
class TopFragment: Fragment() {

    lateinit var edtTopFrag: EditText
    lateinit var textChangedListener: TextChangedListener

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view = inflater!!.inflate(R.layout.fragment_top, container, false)
        edtTopFrag = view.findViewById(R.id.edtTopFrag) as EditText

        edtTopFrag.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                textChangedListener.onTextChanged(s.toString())
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        return view
    }

    public fun setTextChangedCallBack(textChangedListener: TextChangedListener) {
        this.textChangedListener = textChangedListener
    }
}