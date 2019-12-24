package `in`.redbus.android.workmanager

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters

class RBLoggerWorker(val context: Context,
                     val workerParameters: WorkerParameters
) : Worker(context, workerParameters) {

    override fun doWork(): Result {

     return Result.success()
    }
}