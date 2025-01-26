package com.adriangonzalezbesada.gymcodex

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adriangonzalezbesada.gymcodex.ui.theme.GymCodexTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymCodexTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    Column() {
                        Greeting(
                            name = "Android",
                            modifier = Modifier.padding(innerPadding)
                        )
                        HelloScreen(

                        )
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun HelloScreen() {
    var name by rememberSaveable { mutableStateOf("") }
    HelloContent(name = name, onNameChange = { name = it })

}
@Composable
fun HelloContent(name: String, onNameChange: (String) -> Unit, modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Hello, $name",
            modifier = Modifier.padding(bottom = 8.dp),
            style = MaterialTheme.typography.headlineSmall
        )
        OutlinedTextField(
            value = name,
            onValueChange = onNameChange,
            label = { Text("Name") }
        )
    }
}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GymCodexTheme {
        Greeting("Android")
    }
}