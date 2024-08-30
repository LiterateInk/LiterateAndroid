package ink.literate.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workspaces")
data class Workspace (
    @PrimaryKey
    val id: String,
    val name: String
)
