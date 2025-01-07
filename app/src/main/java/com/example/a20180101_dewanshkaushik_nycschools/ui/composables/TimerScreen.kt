package com.example.a20180101_dewanshkaushik_nycschools.ui.composables

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel

    @Composable
    fun TimerScreen(viewModel: MainViewModel = viewModel()) {
        val context = LocalContext.current;
        val timerDuration = 60 // Duration in seconds
        var isTimerRunning by remember { mutableStateOf(false) }
        val timerFlow = remember { mutableStateOf(viewModel.startTimer(timerDuration)) }
        val currentTime by timerFlow.value.collectAsState(initial = timerDuration)

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "$currentTime seconds left", style = MaterialTheme.typography.headlineMedium
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = {
                isTimerRunning = !isTimerRunning
                if (!isTimerRunning) {
                    timerFlow.value = viewModel.startTimer(timerDuration)
                }
            }) {
                Text(if (isTimerRunning) "Restart Timer" else "Start Timer")
            }

            Button(onClick = {
                context.startActivity(Intent(context, CoroutineActivity::class.java))
            }) {
                Text(text = "Show List")
            }

        }
     //   saveDatainApi()
    }

