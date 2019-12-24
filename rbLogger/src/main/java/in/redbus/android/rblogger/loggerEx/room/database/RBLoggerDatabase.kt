package `in`.redbus.android.room.database

import `in`.redbus.android.room.RbLoggerEntity
import `in`.redbus.android.room.dao.RBLoggerDao
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(RbLoggerEntity::class), version = 5)

abstract class RBLoggerDatabase : RoomDatabase() {

    abstract fun rbLoggerDao(): RBLoggerDao

    companion object {
        private var INSTANCE: RBLoggerDatabase? = null

        fun getDatabase(context: Context): RBLoggerDatabase? {
            if (INSTANCE == null) {
                synchronized(RBLoggerDatabase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.getApplicationContext(),
                        RBLoggerDatabase::class.java, "RBLoggerDatabase.db"
                    ).fallbackToDestructiveMigration().build()
                }
            }
            return INSTANCE
        }
    }
}
