package com.example.a20180101_dewanshkaushik_nycschools.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class CoroutineActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // awaitAllMethod()
        // seriesCall()
        supervisorExample()
        setContent {
            MyScreen()
        }
    }

    private fun supervisorExample() {
        val job = SupervisorJob()
        val scope = CoroutineScope(job + Dispatchers.IO)

        scope.launch {
            val first = async { firstFunction() }
//            val exceptions = async { sendException() }
            val second = async { secondFunction() }
            try {
                throw RuntimeException("Child 1 failed!") // Failure here doesn't cancel Child 2
            } catch (e: Exception) {
                e.printStackTrace()
            }

            println(first.await())
//            println(exceptions.await())
            println(second.await())
        }

    }

    fun sendException(): Exception {
        throw Exception()
    }

    @Composable
    fun MyScreen() {
        val context = LocalContext.current;
        var text by rememberSaveable { mutableStateOf("") }

        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween

        ) {
            //row 1
            Row(
                modifier = Modifier.padding(10.dp)
            ) {
                Text(
                    "Coroutine Activity", style = TextStyle(
                        fontSize = 16.sp, textAlign = TextAlign.Center
                    ), modifier = Modifier
                        .padding(16.dp)
                        .weight(1f)
                )
            }

            Column(
                modifier = Modifier
                    .verticalScroll(rememberScrollState())
                    .padding(10.dp)
                    .weight(1f, false)
                //   .height(0.dp)
            ) {
                //row 1
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Coroutine Activity", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    Button(
                        onClick = {
                            context.startActivity(Intent(context, FlowActivity::class.java))
                        }, modifier = Modifier.weight(1f)
                    ) {
                        Text(text = "Mybutton")
                    }
                }
                //row 2
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Name", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = { Text("Enter Name") },
                    )
                }
                //row 2
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Name", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = { Text("Enter Name") },
                    )
                }
                //row 2
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Name", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = { Text("Enter Name") },
                    )
                }
                //row 2
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Name", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = { Text("Enter Name") },
                    )
                }
                //row 2
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Name", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = { Text("Enter Name") },
                    )
                }
                //row 2
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Name", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = { Text("Enter Name") },
                    )
                }
                //row 2
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Name", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = { Text("Enter Name") },
                    )
                }
                //row 2
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Name", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = { Text("Enter Name") },
                    )
                }
                //row 2
                Row(modifier = Modifier.padding(10.dp)) {
                    Text(
                        "Name", style = TextStyle(
                            fontSize = 16.sp, textAlign = TextAlign.Left
                        ), modifier = Modifier
                            .padding(16.dp)
                            .weight(1f)
                    )
                    TextField(
                        value = text,
                        onValueChange = {
                            text = it
                        },
                        label = { Text("Enter Name") },
                    )
                }
            }
        // save button layout
        Row(
            modifier = Modifier.padding(10.dp)
        ) {
            Button(
                onClick = {
                    context.startActivity(Intent(context, FlowActivity::class.java))
                }, modifier = Modifier.weight(1f)
            ) {
                Text(text = "Save")
            }
        }
        }

        saveDatainApi(text)
    }

    fun saveDatainApi(string: String) {

    }

    private fun seriesCall() {
        println("before")
        lifecycleScope.launch {
            val firstresult = async { firstFunction() }
            val secondresult = async { secondFunction() }
            println(firstresult.await())
            println(secondresult.await())
        }
        println("after")
    }

    fun awaitAllMethod() {
        GlobalScope.launch {
            val myvalue = listOf(
                async {
                    secondFunction()
                },
                async {
                    firstFunction()
                })
            println(myvalue.awaitAll())
        }
        println("after")
    }

    suspend fun firstFunction(): String {
        while (true) {
            return "first method"
            delay(1000)
        }
    }

    suspend fun secondFunction(): String {
        while (true) {
            return "second method"
            delay(1000)
        }
    }


}