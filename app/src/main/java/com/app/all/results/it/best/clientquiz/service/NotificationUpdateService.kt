package com.app.all.results.it.best.clientquiz.service

import android.app.*
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.CountDownTimer
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import com.app.all.results.it.best.clientquiz.MainActivity
import com.app.all.results.it.best.clientquiz.R
import com.app.all.results.it.best.clientquiz.utils.TimeFunctions



class NotificationUpdateService : Service() {
    lateinit var mBuilder: NotificationCompat.Builder
    lateinit var notificationManager: NotificationManager
    val NOTIFICATION_ID = 123

    override fun onCreate() {
        super.onCreate()
        initNotification()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        countDownTimer()
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onBind(intent: Intent): IBinder? {
        return null
    }


    internal fun initNotification() {
        notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
        val channelId = "channel-01"
        val channelName = "Channel Name"

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                channelId, channelName, NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(mChannel)
        }
        mBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.mipmap.ic_launcher)
            .setContentTitle(getString(R.string.you_are_on_break))
            .setVibrate(longArrayOf(0L))
        val notification = mBuilder.build()

        notificationManager.notify(NOTIFICATION_ID, mBuilder.build())
        //startForeground(NOTIFICATION_ID, notification)
    }


    fun countDownTimer() {
        var timer = object : CountDownTimer(10000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                // change the notification time on every second
                mBuilder.setContentText(getString(R.string.time_left)+TimeFunctions.millisecondsToTime(millisUntilFinished))
                notificationManager.notify(NOTIFICATION_ID, mBuilder.build())
            }
            override fun onFinish() {
                mBuilder.setContentText(getString(R.string.time_left)+TimeFunctions.millisecondsToTime(0))
                notificationManager.notify(NOTIFICATION_ID, mBuilder.build())
                notificationManager.cancel(NOTIFICATION_ID)
            }
        }
        timer.start()
    }

}