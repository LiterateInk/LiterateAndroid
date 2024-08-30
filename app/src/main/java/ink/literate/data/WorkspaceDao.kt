package ink.literate.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkspaceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(workspace: Workspace)

    @Update
    suspend fun update(workspace: Workspace)

    @Delete
    suspend fun delete(workspace: Workspace)

    @Query("SELECT * from workspaces WHERE id = :id")
    fun getWorkspace(id: String): Flow<Workspace>

    @Query("SELECT * from workspaces ORDER BY name ASC")
    fun getAllWorkspaces(): Flow<List<Workspace>>

    @Query("SELECT COUNT(*) FROM workspaces")
    fun getWorkspacesAmount(): Flow<Int>
}
