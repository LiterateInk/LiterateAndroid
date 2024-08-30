package ink.literate.ui.screens.connectors

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun AssignConnectorsScreen () {
    Column {
        Text("Connectors")
        Text("Which services do you want to add to this workspace ?")

        Row {
            Text("PRONOTE")
        }

        Row {
            Text("EcoleDirecte")
        }

        Row {
            Text("Skolengo")
        }

        Row {
            Text("Moodle")
        }

        Row {
            Text("Izly")
        }

        Row {
            Text("Les Crous")
        }
    }
}