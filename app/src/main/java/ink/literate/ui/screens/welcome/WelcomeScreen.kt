package ink.literate.ui.screens.welcome

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import ink.literate.navigation.Destinations

@Composable
fun WelcomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.padding(16.dp),
    ) {
        Text(text = "Welcome to Literate !", fontSize = 18.sp)
        Text(text = "You're currently looking at a very early version of Literate for Android. This is currently a heavy work in progress and we'd be happy if you can report every single issue you see during your Literate journey, thanks you in advance !", fontSize = 18.sp)
        Button(onClick = {
            navController.navigate(Destinations.CREATE_WORKSPACE)
        }) {
            Text("Join the journey !")
        }
    }
}