package com.example.composeandflows

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeandflows.scenarios.errorhandling.ui.ErrorHandleActivity
import com.example.composeandflows.scenarios.lifecycle.ui.LifecycleExampleActivity
import com.example.composeandflows.ui.theme.ComposeAndFlowsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeAndFlowsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Menu()
                }
            }
        }
    }
}

@Composable
fun Menu(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier
            .padding(20.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        ButtonStartActivity("Error Handling", cls = ErrorHandleActivity::class.java)
        ButtonStartActivity("Lifecycle", cls = LifecycleExampleActivity::class.java)
    }
}

@Composable
fun ButtonStartActivity(title: String, cls: Class<*>) {
    val context = LocalContext.current
    Button(onClick = {
        context.startActivity(
            Intent(
                context,
                cls
            )
        )
    }) {
        Text(title)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeAndFlowsTheme {
        Menu()
    }
}