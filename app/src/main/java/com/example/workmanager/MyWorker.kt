package com.example.workmanager

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.loader.R
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParams: WorkerParameters) :
    Worker(context, workerParams) {
    @SuppressLint("MissingPermission")
    override fun doWork(): Result {
        val notification = NotificationCompat.Builder(applicationContext, "default")
            .setSmallIcon(
                R.drawable.notification_bg
            )
            .setContentTitle("Task completed")
            .setContentText("The background task has completed successfully.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .build()

        // Perform the background task here,
        // such as displaying a notification

        NotificationManagerCompat.from(applicationContext).notify(1, notification)
        return Result.success()
    }
}