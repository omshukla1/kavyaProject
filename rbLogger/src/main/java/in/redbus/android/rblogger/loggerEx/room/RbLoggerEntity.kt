package `in`.redbus.android.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "RBLogger")
data class RbLoggerEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @ColumnInfo(name = "content") var content: String,
    @ColumnInfo(name = "deviceID") var deviceId: String,
    @ColumnInfo(name = "timestamp") var timeStamp: String,
    @ColumnInfo(name = "country_code") var countrycode: String,
    @ColumnInfo(name = "logType") var logType: String,
    @ColumnInfo(name = "message") var message: String,
    @ColumnInfo(name = "exception") var exception: String,
    @ColumnInfo(name = "appVersion") var appVersion: String
)