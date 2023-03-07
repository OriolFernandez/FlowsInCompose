package com.example.composeandflows.scenarios.lifecycle.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import com.example.composeandflows.scenarios.lifecycle.domain.model.Counters
import com.example.composeandflows.ui.theme.ComposeAndFlowsTheme
import kotlinx.coroutines.flow.Flow
import org.koin.androidx.compose.koinViewModel

class LifecycleExampleActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        println("Main activity created")
        setContent {
            ComposeAndFlowsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainComposable()
                }
            }
        }
    }
}

// DON'T
/*
@Composable
fun MainComposable(
    viewModel: CounterViewModel = koinViewModel()
) {
    val counters by viewModel.getCounters().collectAsState(Counters(0, 0))
    ShowCounters(counter1 = counters.counter1, counter2 = counters.counter2)
}
*/
@Composable
fun MainComposable(
    viewModel: CounterViewModel = koinViewModel()
) {
    val counters: Flow<Counters> = viewModel.getCounters()
    Counters(counters)
}

@Composable
fun Counters(flow: Flow<Counters>) {
    val counters by flow.collectAsState(Counters(0, 0))
    ShowCounters(counter1 = counters.counter1, counter2 = counters.counter2)
}

@Composable
fun ShowCounters(counter1: Int, counter2: Int) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Counter 1:${counter1} ")
        Text("Counter 2:${counter2} ")
    }
}

@Preview(showBackground = true)
@Composable
fun CountersPreview() {
    ShowCounters(1, 2)
}