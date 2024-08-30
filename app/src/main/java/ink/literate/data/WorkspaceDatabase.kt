package ink.literate.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Workspace::class], version = 1, exportSchema = false)
abstract class WorkspaceDatabase : RoomDatabase() {
    abstract fun dao(): WorkspaceDao

    companion object {
        @Volatile
        private var Instance: WorkspaceDatabase? = null

        fun getDatabase(context: Context): WorkspaceDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, WorkspaceDatabase::class.java, "workspace-db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}