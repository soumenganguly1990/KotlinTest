package com.qi.kotlintest.activities

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.qi.kotlintest.R
import com.qi.kotlintest.common.AppCommonValues

class MainActivity : AppCompatActivity() {

    lateinit var edtUserId : EditText
    lateinit var edtPassword : EditText
    lateinit var btnLogin : Button
    lateinit var txtVersion : TextView
    lateinit var txtAboutUs : TextView
    lateinit var txtVersionDetails : TextView

    fun Context.toast(message : CharSequence, duration: Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, message, duration).show();
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* just for testing purposes */
        val stat = AppCommonValues.executeClassA()
        val stat2 = AppCommonValues.checkInheritance()

        edtUserId = findViewById(R.id.edtUserId) as EditText
        edtPassword = findViewById(R.id.edtPassword) as EditText
        btnLogin = findViewById(R.id.btnLogin) as Button
        txtVersion = findViewById(R.id.txtVersion) as TextView
        txtAboutUs = findViewById(R.id.txtAboutUs) as TextView
        txtVersionDetails = findViewById(R.id.txtVersionDetails) as TextView

        var clickListener = View.OnClickListener { v ->
            when (v.id) {
                R.id.btnLogin -> {
                    var uid : String = edtUserId.text.trim().toString()
                    var pwd : String = edtPassword.text.trim().toString()
                    if (uid.isNullOrBlank() || pwd.isNullOrBlank()) {
                        toast("Both inputs required");
                    } else {
                        if (uid.equals("sam") && pwd.equals("123")) {
                            var dashIntent = Intent(this@MainActivity, DashBoardActivity::class.java)
                            startActivity(dashIntent)
                        } else {
                            toast("Wrong login credentials")
                        }
                    }
                }
                R.id.txtAboutUs -> showAboutUs()
                R.id.txtVersion -> {
                    if (txtVersionDetails.visibility == View.GONE) {
                        var packageInfo = this.packageManager.getPackageInfo(packageName, 0);
                        txtVersionDetails.text = "Version Code: " + packageInfo.versionCode +
                                "\nVersion Number: " + packageInfo.versionName;
                        txtVersionDetails.visibility = View.VISIBLE
                    } else {
                        txtVersionDetails.visibility = View.GONE
                    }
                }
            }
        }
        btnLogin.setOnClickListener(clickListener)
        txtAboutUs.setOnClickListener(clickListener)
        txtVersion.setOnClickListener(clickListener)
    }

    /**
     * Simple alert
     */
    private fun showAboutUs() {
        val aboutAlert = AlertDialog.Builder(this@MainActivity).create()
        aboutAlert.setTitle("About Us")
        aboutAlert.setMessage("I am someone, who is very excited about kotlin, So you want to see a simple toast?")
        aboutAlert.setButton(AlertDialog.BUTTON_POSITIVE, "YES", {
            dialogInterface, i -> toast("Okay, here is your toast")
        })
        aboutAlert.setButton(AlertDialog.BUTTON_NEGATIVE, "NO", {
            dialogInterface, i ->
        })
        aboutAlert.setButton(AlertDialog.BUTTON_NEUTRAL, "Other", {
            dialogInterface, i -> showCustomAboutUs()
        })
        aboutAlert.show()
    }

    /**
     * Alert with custom view
     */
    private fun showCustomAboutUs() {
        var aboutDialogBuilder = AlertDialog.Builder(this@MainActivity)

        var layoutInflatr = this@MainActivity.layoutInflater;
        var view = layoutInflatr.inflate(R.layout.dialog_aboutcustom, null)
        aboutDialogBuilder.setView(view)

        var edtWrite = view.findViewById(R.id.edtWrite) as EditText
        var btnClose = view.findViewById(R.id.btnClose) as Button

        var aboutAlert = aboutDialogBuilder.create();
        aboutAlert.show()

        btnClose.setOnClickListener(View.OnClickListener {
            aboutAlert.dismiss()
            toast(edtWrite.text.trim().toString())
        })
    }

    override fun onResume() {
        super.onResume()
        Log.e("onResume()", "onResume() was called")
    }

    override fun onStart() {
        super.onStart()
        Log.e("onStart()", "onStart() was called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("onDestroy()", "onDestroy() was called")
    }
}