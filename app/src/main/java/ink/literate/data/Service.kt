package ink.literate.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "services")
data class Service(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String
)
