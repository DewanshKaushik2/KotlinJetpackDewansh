package com.example.a20180101_dewanshkaushik_nycschools.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.a20180101_dewanshkaushik_nycschools.MVVMApplication
import com.example.a20180101_dewanshkaushik_nycschools.component.DaggerActivityComponent
import com.example.a20180101_dewanshkaushik_nycschools.module.ActivityModule
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.FlowViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

class FlowActivity : AppCompatActivity() {
    val TAG = FlowActivity::class.java.name

    @Inject
    lateinit var flowViewModel: FlowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()

        setContent {
            Loading()
        }
        lifecycleScope.launch {
            flowViewModel.emitEvent("1")
            flowViewModel.emitEvent("2")
            flowViewModel.emitEvent("3")
        }
        lifecycleScope.launch {
            flowViewModel.events.collect { value ->
                Log.e(TAG, value)
            }
        }
        lifecycleScope.launch {
            flowViewModel.events.collect { value ->
                Log.e(TAG, value)
            }
        }
        GlobalScope.launch {
                val sharedFlow = flow<Int>{
                    emit(1)
                    emit(2)
                    emit(3)
                }

                // Collecting values
                launch {
                    sharedFlow.collect { value ->
                        println("Collector received: $value")
                    }
                }

                // New collector
                launch {
                    sharedFlow.collect { value ->
                        println("New collector received: $value")
                    }
                }
            // Emitting values
            launch {
            }

        }
    }

    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as MVVMApplication).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this)
    }

    @Composable
    fun Loading() {
        Column {

            Text(
                "Flow Activity", style = TextStyle(
                    fontSize = 16.sp, textAlign = TextAlign.Center
                ), modifier = Modifier.padding(16.dp)
            )
            Button(onClick = {

            }) {
                Text(text = "button")
            }
        }

    }


}