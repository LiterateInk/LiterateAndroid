package ink.literate.ui.screens.workspace

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import ink.literate.data.WorkspaceDao
import ink.literate.navigation.Destinations

@Composable
fun HomeScreen(
    navigation: NavController,
    dao: WorkspaceDao
) {
    
    Column {
        Text("Welcome to your workspace !")
        Button(onClick = {
            navigation.navigate(Destinations.CREATE_WORKSPACE)
        }) {
            Text("Create a new workspace")
        }
    }

}