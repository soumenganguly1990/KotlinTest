package com.qi.kotlintest.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.design.widget.NavigationView
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Gravity
import android.view.MenuItem
import android.view.View
import android.widget.FrameLayout
import com.qi.kotlintest.R
import com.qi.kotlintest.fragments.FragmentC
import com.qi.kotlintest.fragments.FragmentD
import com.qi.kotlintest.utils.NavigationForWhat
import com.qi.kotlintest.utils.ToWhichFragment
import org.jetbrains.anko.*

class DashBoardActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit var navigation_view: NavigationView
    lateinit var frmContainer: FrameLayout
    lateinit var fragmentC : FragmentC
    lateinit var fragmentD : FragmentD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        toolbar = findViewById(R.id.toolbar) as Toolbar
        drawerLayout = findViewById(R.id.drwDrawer) as DrawerLayout;
        navigation_view = findViewById(R.id.navigation_view) as NavigationView
        frmContainer = findViewById(R.id.frmContainer) as FrameLayout

        fragmentC = FragmentC()
        fragmentD = FragmentD()

        setSupportActionBar(toolbar)
        initNavigationDrawer();
    }

    private fun initNavigationDrawer() {
        navigation_view.setNavigationItemSelectedListener { item: MenuItem ->
            var itemId = item.itemId
            when (itemId) {
                R.id.option_a -> {
                    drawerLayout.closeDrawers()
                    performDrawerAction(NavigationForWhat.OPTION_A)
                }
                R.id.option_b -> {
                    drawerLayout.closeDrawers()
                    performDrawerAction(NavigationForWhat.OPTION_B)
                }
                R.id.option_c -> {
                    drawerLayout.closeDrawers()
                    performDrawerAction(NavigationForWhat.OPTION_C)
                }
                R.id.option_d -> {
                    drawerLayout.closeDrawers()
                    performDrawerAction(NavigationForWhat.OPTION_D)
                }
                R.id.mnuComplex -> {
                    drawerLayout.closeDrawers()
                    performDrawerAction(NavigationForWhat.OPTION_COMPLEX)
                }
                R.id.mnuEvent -> {
                    drawerLayout.closeDrawers()
                    performDrawerAction(NavigationForWhat.OPTION_EVENT)
                }
                R.id.mnuObjectBox -> {
                    drawerLayout.closeDrawers()
                    performDrawerAction(NavigationForWhat.OPTION_OBJECTBOX)
                }
                R.id.mnuRxJavaTest -> {
                    drawerLayout.closeDrawers()
                    performDrawerAction(NavigationForWhat.OPTION_RXJAVA)
                }
            }
            false
        }
        var drawerToggle = object : ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close) {
            override fun onDrawerOpened(drawerView: View?) {
                super.onDrawerOpened(drawerView)
            }

            override fun onDrawerClosed(drawerView: View?) {
                super.onDrawerClosed(drawerView)
            }
        }
        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
    }

    private fun performDrawerAction(navigationForWhat: NavigationForWhat = NavigationForWhat.OPTION_A) {
        var mHandler = Handler()
        var goingTo: String = "Selected Fragment "
        mHandler.postDelayed(Runnable {
            mHandler.removeCallbacks { this }
            when (navigationForWhat) {
                NavigationForWhat.OPTION_A -> {
                    toast(goingTo + "A, but sad thing is, it is not going to do anything")
                }
                NavigationForWhat.OPTION_B -> {
                    alert("This is a simple alertdialog, created with anko-commons\nOpen Drawer again", "Hello!!") {
                        yesButton { drawerLayout.openDrawer(Gravity.START) }
                        noButton { performFragmentTransactionAction(ToWhichFragment.ERRORFRAGMENT) }
                    }.show()
                }
                NavigationForWhat.OPTION_C -> {
                    toast(goingTo + "C")
                    performFragmentTransactionAction(ToWhichFragment.FRAGMENT_C)
                }
                NavigationForWhat.OPTION_D -> {
                    toast(goingTo + "D")
                    performFragmentTransactionAction(ToWhichFragment.FRAGMENT_D)
                }
                NavigationForWhat.OPTION_COMPLEX -> {
                    var i: Intent = Intent(this@DashBoardActivity, ComplexActivity::class.java)
                    startActivity(i)
                }
                NavigationForWhat.OPTION_EVENT -> {
                    toast(goingTo + "EventBusActivity")
                    var i: Intent = Intent(this@DashBoardActivity, EventBusActivity::class.java)
                    startActivity(i)
                }
                NavigationForWhat.OPTION_OBJECTBOX -> {
                }
                NavigationForWhat.OPTION_RXJAVA -> {
                }
            }
        }, 300)
    }

    private fun performFragmentTransactionAction(whichFragment: ToWhichFragment) {
        when (whichFragment) {
            ToWhichFragment.FRAGMENT_C -> {
                clearFragmentStack()
                var transaction = fragmentManager.beginTransaction()
                transaction!!.replace(R.id.frmContainer, fragmentC)
                transaction!!.commit()
            }
            ToWhichFragment.FRAGMENT_D -> {
                clearFragmentStack()
                var transaction = fragmentManager.beginTransaction()
                transaction!!.replace(R.id.frmContainer, fragmentD)
                transaction!!.commit()
            }
            else -> {
                var countries = listOf("Brazil", "Russia", "India", "China", "South Africa")
                selector("Where are you from??", countries, { dialogInterface, i ->
                    toast("You are from ${countries[i]}")
                })
            }
        }
    }

    private fun clearFragmentStack() {
        var manager = fragmentManager
        var range : Int = manager!!.backStackEntryCount
        for(i in 0..range) {
            manager!!.popBackStack()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}