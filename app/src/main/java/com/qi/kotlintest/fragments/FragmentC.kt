package com.qi.kotlintest.fragments

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.qi.kotlintest.R

/**
 * Created by Soumen on 11-09-2017.
 */
class FragmentC : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var view = inflater!!.inflate(R.layout.fragment_c, container, false);
        return view;
    }
}