package com.example.composeandflows.scenarios.errorhandling.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview
import com.example.composeandflows.domain.model.GPSCoordinate
import com.example.composeandflows.scenarios.errorhandling.viewmodel.ErrorHandleViewModel
import com.example.composeandflows.ui.theme.ComposeAndFlowsTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class ErrorHandleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: ErrorHandleViewModel by viewModel()
        setContent {
            ComposeAndFlowsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    RouteComposable(viewModel)
                }
            }
        }
    }
}

@Composable
fun RouteComposable(viewModel: ErrorHandleViewModel, modifier: Modifier = Modifier) {
    viewModel.viewState.collectAsState()
    StartButton(modifier = modifier) {
        viewModel.startReceivingCoordinates()
    }
}

@Composable
fun StartButton(modifier: Modifier = Modifier, onStart: () -> Unit) {
    Button(modifier = modifier, onClick = onStart) {
        Text(text = "Start")
    }
}

@Composable
fun ShowCoordinate(coordinate: GPSCoordinate) {
    Column {
        Text("Lat:${coordinate.latitude} Long:${coordinate.longitude}")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    StartButton {
    }
}