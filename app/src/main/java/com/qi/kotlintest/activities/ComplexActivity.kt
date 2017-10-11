package com.qi.kotlintest.activities

import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.widget.FrameLayout
import com.qi.kotlintest.R
import com.qi.kotlintest.fragments.BottomFragment
import com.qi.kotlintest.fragments.MiddleFragment
import com.qi.kotlintest.fragments.TopFragment

class ComplexActivity : FragmentActivity() {

    lateinit var frmFrag1: FrameLayout
    lateinit var frmFrag2: FrameLayout
    lateinit var frmFrag3: FrameLayout

    var topFragment = TopFragment()
    var middleFragment = MiddleFragment()
    var bottomFragment = BottomFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_complex)

        frmFrag1 = findViewById(R.id.frmFrag1) as FrameLayout
        frmFrag2 = findViewById(R.id.frmFrag2) as FrameLayout
        frmFrag3 = findViewById(R.id.frmFrag3) as FrameLayout

        var manager = fragmentManager
        var fragmentTransactionManager = manager.beginTransaction()
        fragmentTransactionManager.add(R.id.frmFrag1, topFragment)
        fragmentTransactionManager.add(R.id.frmFrag2, middleFragment)
        fragmentTransactionManager.add(R.id.frmFrag3, bottomFragment)
        fragmentTransactionManager.commit()

        topFragment.setTextChangedCallBack(bottomFragment)
        bottomFragment.setButtonClickedCallback(middleFragment)
    }
}