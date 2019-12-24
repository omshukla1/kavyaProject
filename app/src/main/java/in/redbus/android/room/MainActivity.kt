package `in`.redbus.android.room


import `in`.redbus.android.rblogger.RbLogger
import `in`.redbus.android.workmanager.RBLoggerWorker
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.work.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RbLogger.getInstance(this).
            logMessage(RbLoggerEntity(1,"message","","","","","","",""))
        pushDataToServer()
    }


    private fun pushDataToServer() {
        val notificationWork = OneTimeWorkRequest.Builder(
            RBLoggerWorker::class.java)
            .setInitialDelay(1, TimeUnit.MINUTES)
            .setConstraints(
                Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).setTriggerContentMaxDelay(
                    1,
                    TimeUnit.HOURS)
                    .setRequiresBatteryNotLow(true)
                    .build())
            .build()
        WorkManager.getInstance(applicationContext).enqueue(notificationWork)
    }
}
