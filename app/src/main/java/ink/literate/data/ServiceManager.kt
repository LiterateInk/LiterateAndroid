package ink.literate.data

import android.content.Context
import androidx.room.Room

object ServiceManager {
    private val databases = mutableMapOf<String, ServiceDatabase>()

    fun getServiceDatabase(context: Context, workspaceId: String): ServiceDatabase {
        return databases.getOrPut(workspaceId) {
            Room.databaseBuilder(
                context.applicationContext,
                ServiceDatabase::class.java,
                "service-db-$workspaceId"
            ).build()
        }
    }

    fun closeDatabase(workspaceId: String) {
        databases[workspaceId]?.close()
        databases.remove(workspaceId)
    }
}
