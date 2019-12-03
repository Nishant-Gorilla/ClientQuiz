package com.app.all.results.it.best.clientquiz

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.app.all.results.it.best.clientquiz.databinding.ActivityMainBinding
import com.app.all.results.it.best.clientquiz.service.NotificationUpdateService
import com.app.all.results.it.best.clientquiz.utils.CommonFunctions
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    // inject the common function
    val commonFunctions: CommonFunctions by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setUpData()
    }


    //<editor-fold desc="set up all initial data here">
    fun setUpData() {
      
        // Get value of build varient type and supply to the view file
        binding.buildVarient = commonFunctions.getBuildVarient()


        // start service if not running already
        if(!commonFunctions.isNotificationServiceRunning(this, NotificationUpdateService::class.java)){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                startForegroundService(Intent(this@MainActivity, NotificationUpdateService::class.java))
            } else {
                startService(Intent(this@MainActivity, NotificationUpdateService::class.java))
            }
        }

    }
    //</editor-fold>


}
