package ink.literate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import ink.literate.ui.screens.welcome.WelcomeScreen
import ink.literate.ui.theme.LiterateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            App()
        }
    }
}


@Composable
fun App() {
    LiterateTheme {
        WelcomeScreen()
    }
}
