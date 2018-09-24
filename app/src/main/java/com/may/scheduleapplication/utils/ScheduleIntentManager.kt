package com.may.scheduleapplication.utils

import android.app.Activity
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.SystemClock

class ScheduleIntentManager(private val mContext: Context) : IScheduleIntentManager {
    override fun schedule(url: String) {
        val intentForPackage = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        setAlarmManager(mContext, intentForPackage)
    }

    override fun schedule(intent: Intent) {
        setAlarmManager(mContext, intent)
    }

    private fun setAlarmManager(context: Context, intent: Intent) {
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)
        val systemService = context.getSystemService(Activity.ALARM_SERVICE) as AlarmManager
        systemService.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,
                SystemClock.elapsedRealtime() + 10 * 1000,
                pendingIntent)
    }
}