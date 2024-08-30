package ink.literate.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface ServiceDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(service: Service)

    @Update
    suspend fun update(service: Service)

    @Delete
    suspend fun delete(service: Service)

    @Query("SELECT * from services WHERE id = :id")
    fun getService(id: Int): Flow<Service>

    @Query("SELECT * from services ORDER BY name ASC")
    fun getAllServices(): Flow<List<Service>>
}
