package com.example.workmanager


import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.Constraints.Builder
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import androidx.work.WorkRequest
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val channel =
            NotificationChannel("default", "Default", NotificationManager.IMPORTANCE_DEFAULT)
        val notificationManager = getSystemService(NotificationManager::class.java)
        notificationManager.createNotificationChannel(channel)

        val notificationWorkRequest: WorkRequest = OneTimeWorkRequest.Builder(MyWorker::class.java)
            .setInitialDelay(2, TimeUnit.MINUTES)
            .build()
        Log.i("WorkManager",notificationWorkRequest.toString())

        // Schedule the WorkRequest with WorkManager
        WorkManager.getInstance(this).enqueue(notificationWorkRequest)
    }
}