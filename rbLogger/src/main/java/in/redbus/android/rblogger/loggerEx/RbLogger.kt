package `in`.redbus.android.rblogger

import `in`.redbus.android.room.RbLoggerEntity
import `in`.redbus.android.room.database.RBLoggerDatabase
import android.content.Context
import android.util.Log

class RbLogger {
    companion object {
         var rbLogger : RbLogger? = null
         lateinit var context: Context

        fun getInstance(context: Context) : RbLogger{
           if(rbLogger == null ){
               this.context = context
                rbLogger = RbLogger()
               return rbLogger as RbLogger
           }
            else
               return rbLogger as RbLogger
       }
    }

    fun logMessage(rbLogger: RbLoggerEntity) {
      pushDataToRoom(rbLogger)
    }

    private fun pushDataToRoom(rbLogger: RbLoggerEntity) {
        Thread(Runnable {
            val database = RBLoggerDatabase.getDatabase(context)
            database?.rbLoggerDao()?.addRBLogger(rbLogger)
            Log.d("dblogger", database?.rbLoggerDao()?.getUser().toString())
        }).start()
    }
}