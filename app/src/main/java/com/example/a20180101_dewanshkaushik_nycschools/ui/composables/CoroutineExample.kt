package com.example.a20180101_dewanshkaushik_nycschools.ui.composables

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import com.example.a20180101_dewanshkaushik_nycschools.StudentItem
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.UiState
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject


open class CoroutineExample() {
    @Inject
    lateinit var mainViewModel: MainViewModel

    var MYTAG: String = "MainActivity"

    @Composable
    fun CoroutineExample() {

        LaunchedEffect(Unit) {
            GlobalScope.launch {
                val ss = async {
                    printData({ result ->
                        //use result
                        println("mainhu" + result.toString())

                    })
                }
                val dd = ss.await();
                //d   Greeting(blogList = dd)
            }
        }

    }

    @Composable
    fun MyScreen() {
        val scope = rememberCoroutineScope()
        LaunchedEffect(Unit) {

        }
        Button(onClick = {
            scope.launch {
                // Perform asynchronous operation here, e.g., show a Snackbar
               // snackbarHostState.showSnackbar("Action completed!")
                scope.launch {

                }
            }
        }) {
            Text("Perform Action")
        }
    }
    suspend fun printData(myCallback: (result: ArrayList<StudentItem>?) -> Unit) {
        var list: ArrayList<StudentItem>
        mainViewModel.uiState.collect {
            when (it) {
                is UiState.Error -> {
                    Log.e(MYTAG.toString(), "Error")
                }

                is UiState.Loading -> {
                    Log.e(MYTAG.toString(), "Loading")
                }

                is UiState.Success -> {
                    Log.e(MYTAG.toString(), it.data.toString())
                    myCallback.invoke(it.data)
                }
            }
        }
    }
}

