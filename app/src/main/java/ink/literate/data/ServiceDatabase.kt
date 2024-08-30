package ink.literate.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Service::class], version = 1, exportSchema = false)
abstract class ServiceDatabase : RoomDatabase() {
    abstract fun dao(): ServiceDao
}
