package `in`.redbus.android.room.dao

import `in`.redbus.android.room.RbLoggerEntity
import androidx.room.*




@Dao
interface RBLoggerDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addRBLogger(rbLogger: RbLoggerEntity)

    @Delete
    fun deleteRbLogger(rbLogger: RbLoggerEntity)


    @Query("DELETE FROM `RBLogger`")
    fun deleteAllLogs()

    @Query("SELECT * FROM `RBLogger`")
    fun getUser():List<RbLoggerEntity>

}