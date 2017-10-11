package com.qi.kotlintest.eventmodels

/**
 * Created by Soumen on 11-10-2017.
 */
data class EventBusTestModel (
        var headerContent: String,
        var textContext: String,
        var timeStamp: Long
)