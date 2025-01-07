package com.example.a20180101_dewanshkaushik_nycschools.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.example.a20180101_dewanshkaushik_nycschools.MVVMApplication
import com.example.a20180101_dewanshkaushik_nycschools.component.DaggerActivityComponent
import com.example.a20180101_dewanshkaushik_nycschools.models.StudentDetailItem
import com.example.a20180101_dewanshkaushik_nycschools.models.UiStateSecond
import com.example.a20180101_dewanshkaushik_nycschools.module.ActivityModule
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.FlowViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class FlowActivity : AppCompatActivity() {
    val TAG = FlowActivity::class.java.name

    @Inject
    lateinit var flowViewModel: FlowViewModel

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
        val message = intent.getStringExtra("MESSAGE")

            setContent {
                Loading(
                    StudentDetailItem(
                        "", "", "", "", "", ""
                    )
                )
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
            val sharedFlow = flow<Int> {
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
            launch {}

        }
        lifecycleScope.launch {
            flowViewModel.uiState.collect { it ->
                when (it) {
                    is UiStateSecond.Error -> {
                        Log.e(MYTAG.toString(), "Error")
                    }

                    is UiStateSecond.Loading -> {
                        Log.e(MYTAG.toString(), "Loading")
                    }

                    is UiStateSecond.Success -> {
                        Log.e(MYTAG.toString(), it.data.toString())
                        val items = it.data
                        for (i in items) {
                            if (message.equals(i.dbn)) {
                                println(i)
                                setContent {
                                    Loading(studentItem = i)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    val MYTAG = FlowActivity::class.java.simpleName
    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as MVVMApplication).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this)
    }

    @Composable
    fun Loading(studentItem: StudentDetailItem) {
        Column {
        //    LoadingScreen()

//first
            Row {
                Text(
                    "School Name", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
                Text(
                    studentItem.school_name.toString(), style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
            }

//second
            Row {

                Text(
                    "Num of sat test takers", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                        .weight(1f)
                )
                Text(
                    studentItem.num_of_sat_test_takers.toString(), style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )

            }
//third
            Row {

                Text(
                    "Sat critical reading avg score", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                        .weight(1f)
                )
                Text(
                    studentItem.sat_critical_reading_avg_score.toString(), style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )

            }
//fourth
            Row {

                Text(
                    "Sat math avg score", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                        .weight(1f)
                )
                Text(
                    studentItem.sat_math_avg_score.toString(), style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )

            }
//fifth
            Row {

                Text(
                    "Sat writing avg score", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier.padding(16.dp)
                        .weight(1f)

                )
                Text(
                    studentItem.sat_writing_avg_score.toString(), style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )

            }
        }

    }

    @Composable
    fun LoadingScreen() {
        val state = flowViewModel.loading.collectAsState()
        val counter = flowViewModel.counterState.collectAsState()
        var variable = rememberSaveable { "" }
        // Content when not loading
        LaunchedEffect(Unit) {
            flowViewModel.counterState.collect { value ->
                variable = value.toString()
            }
        }
        Text(
            variable, style = TextStyle(
                fontSize = 16.sp, textAlign = TextAlign.Center
            ), modifier = Modifier.padding(16.dp)
        )
        val statedd = state.value
        if (statedd) {
            // Show CircularProgressIndicator while loading
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.Center)
            ) {
                CircularProgressIndicator()
            }
        } else {
        }
    }

}