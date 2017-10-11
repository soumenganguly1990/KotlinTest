package com.qi.kotlintest.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatButton
import android.widget.EditText
import android.widget.TextView
import com.qi.kotlintest.R
import com.qi.kotlintest.eventmodels.EventBusTestModel
import com.qi.kotlintest.utils.bindView
import com.qi.kotlintest.utils.bindViews
import com.qi.kotlintest.utils.onClick
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class EventBusActivity : AppCompatActivity() {

    val edtHeader: EditText by bindView(R.id.edtHeader)
    val edtContent: EditText by bindView(R.id.edtContent)
    val btnFire: AppCompatButton by bindView(R.id.btnFire)
    val textViews: List<TextView> by bindViews(R.id.txtHeader, R.id.txtContent)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_event_bus)
        handleClicks()
    }

    public fun handleClicks() {
        btnFire.onClick {
            var e1: EventBusTestModel = EventBusTestModel(
                    edtHeader!!.text.toString().trim(),
                    edtContent!!.text.toString().trim(),
                    System.currentTimeMillis()
            )
            EventBus.getDefault().post(e1!!)
        }
    }

    override fun onResume() {
        super.onResume()
        EventBus.getDefault().register(this@EventBusActivity)
    }

    override fun onPause() {
        super.onPause()
        EventBus.getDefault().unregister(this@EventBusActivity)
    }

    override fun onDestroy() {
        super.onDestroy()
        EventBus.getDefault().unregister(this@EventBusActivity)
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onMessageEvent(e1: EventBusTestModel) {
        textViews.forEach {
            when(it.id) {
                R.id.txtHeader -> {
                    it!!.text = e1!!.headerContent
                }
                R.id.txtContent -> {
                    it!!.text = e1!!.textContext + "\n" + e1!!.timeStamp
                }
            }
        }
    }
}