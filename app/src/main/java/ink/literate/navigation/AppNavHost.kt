package ink.literate.navigation

import android.content.Context
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ink.literate.data.WorkspaceDatabase
import ink.literate.ui.screens.connectors.AssignConnectorsScreen
import ink.literate.ui.screens.welcome.CreateWorkspaceScreen
import ink.literate.ui.screens.welcome.WelcomeScreen
import ink.literate.ui.screens.workspace.HomeScreen

@Composable
fun AppNavHost(navController: NavHostController, applicationContext: Context) {
    val workspaceDao = WorkspaceDatabase.getDatabase(applicationContext).dao()
    val workspacesAmount by workspaceDao.getWorkspacesAmount().collectAsState(initial = null)

    var startDestination: String? by remember {
        mutableStateOf(null)
    }

    LaunchedEffect(workspacesAmount) {
        if (workspacesAmount != null && startDestination == null) {
            startDestination = if (workspacesAmount!! > 0)
                Destinations.HOME
            else Destinations.WELCOME
        }
    }

    if (startDestination == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        NavHost(navController, startDestination = startDestination!!) {
            composable(Destinations.WELCOME) {
                WelcomeScreen(navController)
            }
            composable(Destinations.CREATE_WORKSPACE) {
                CreateWorkspaceScreen(navController, workspaceDao)
            }
            composable(Destinations.ASSIGN_CONNECTORS) {
                AssignConnectorsScreen()
            }
            composable(Destinations.HOME) {
                HomeScreen(navController, workspaceDao)
            }
        }
    }
}
