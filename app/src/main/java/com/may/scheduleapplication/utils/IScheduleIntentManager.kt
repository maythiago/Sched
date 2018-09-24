package com.may.scheduleapplication.utils

import android.content.Intent

interface IScheduleIntentManager {
    fun schedule(url: String)
    fun schedule(intent: Intent)
}
