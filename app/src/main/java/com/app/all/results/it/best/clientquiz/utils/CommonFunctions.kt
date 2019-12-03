package com.app.all.results.it.best.clientquiz.utils

import com.app.all.results.it.best.clientquiz.BuildConfig
import android.app.ActivityManager
import android.content.Context
import android.content.Context.ACTIVITY_SERVICE
import androidx.core.content.ContextCompat.getSystemService



class CommonFunctions {
    //<editor-fold desc="funtion used to get build varient">
    fun getBuildVarient():String{
        return BuildConfig.FLAVOUR_NAME
    }
    //</editor-fold>


     fun isNotificationServiceRunning(context: Context, serviceClass: Class<*>): Boolean {
        val manager = context.getSystemService(ACTIVITY_SERVICE) as ActivityManager?
        for (service in manager!!.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.name == service.service.className) {
                return true
            }
        }
        return false
    }
}