package ink.literate.ui.screens.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ink.literate.data.Workspace
import ink.literate.data.WorkspaceDao
import ink.literate.navigation.Destinations
import kotlinx.coroutines.launch
import java.util.UUID

@Composable
fun CreateWorkspaceScreen(
    navigation: NavController,
    dao: WorkspaceDao
) {
    var workspaceName by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier.padding(16.dp, 64.dp, 16.dp, 16.dp),
    ) {
        Text("My workspace", fontSize = 24.sp, fontWeight = FontWeight.SemiBold)
        Text("A workspace is a place where you can organize and manage your student life.", fontSize = 16.sp)
        Text("Configure your workspace so it just feels like home. Everything here will still be customizable once setup.", fontSize = 16.sp)
        OutlinedTextField(
            value = workspaceName,
            onValueChange = { workspaceName = it },
            label = { Text("Name") },
            placeholder = { Text("Yann's workspace") }
        )
        Text("Since you can add even more workspaces, you might need to name well them to recognize each of them.")
        OutlinedButton(onClick = {
            navigation.navigate(Destinations.WELCOME)
        }) {
            Text("Cancel")
        }
        Button(onClick = {
            val uuid = UUID.randomUUID().toString()
            val workspace = Workspace(
                id = uuid,
                name = workspaceName,
            )

            scope.launch {
                dao.insert(workspace)
                navigation.navigate(Destinations.ASSIGN_CONNECTORS)
            }
        }) {
            Text("Continue")
        }
    }
}