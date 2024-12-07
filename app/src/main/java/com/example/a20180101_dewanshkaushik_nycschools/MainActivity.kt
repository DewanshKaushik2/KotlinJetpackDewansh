package com.example.a20180101_dewanshkaushik_nycschools

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a20180101_dewanshkaushik_nycschools.component.DaggerActivityComponent
import com.example.a20180101_dewanshkaushik_nycschools.module.ActivityModule
import com.example.a20180101_dewanshkaushik_nycschools.ui.theme.JetpackComposeAndroidExamplesTheme
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject


//https://github.com/lubnamariyam/MovieList_Retrofit_API_In_Compose
//https://www.youtube.com/watch?v=bIVGIEMgc7Q&t=49s
class MainActivity : AppCompatActivity() {
    var MYTAG: String = "MainActivity"

    // inject viewmodel in activity
    @Inject
    lateinit var mainViewModel: MainViewModel

    fun myMethod() {
        println("before")

//        GlobalScope.launch {
//            val myvalue = async {
//                helloss("hi")
//            }
//            println(myvalue.await())
//        }
//        println("after")
//
        runBlocking {
            launch {
                delay(1000)
                helloss("hi-launch")
            }
            async {
                delay(500)
                helloss("hi-async")
            }
        }
    }

    suspend fun helloss(value: String): String {
        return "data processed $value"
    }

    @Inject
    lateinit var topHeadlineRepository: TopHeadlineRepository
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e(MYTAG, "");
        injectDependencies()
        myMethod()
        setContent {
            JetpackComposeAndroidExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val list = mutableListOf<StudentItem>()
                    Greeting(mainViewModel)

                }
            }
        }
    }


    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as MVVMApplication).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this)
    }

    @Composable
    fun LoadingScreen() {
        val state = mainViewModel.loading.collectAsState()
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
            // Content when not loading
            Text("Content loaded!")
        }
    }

    @Composable
    fun Greeting(mainViewModel: MainViewModel) {
        LoadingScreen()
        val posts by mainViewModel.posts
        Log.e("MainActivity", posts.toString())

        //new column
        val context = LocalContext.current
        val openAlertDialog = rememberSaveable { mutableStateOf(false) }

        LazyColumn {
            itemsIndexed(posts) { index, item ->

                Column {
                    if (item == null) return@Column
                    Card(

                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable(onClick = {
                                openAlertDialog.value = true;
                                Toast
                                    .makeText(
                                        context,
                                        "Author: ${item.academicopportunities1}",
                                        Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    ) {

                        val dd = item.academicopportunities1 ?: "null"
                        val newIndex = index + 1;
                        val tt = "" + newIndex + "->" + dd + ""
                        Log.e("MainActivity", newIndex.toString())

                        Text(
                            tt, style = TextStyle(
                                fontSize = 16.sp, textAlign = TextAlign.Center
                            ), modifier = Modifier.padding(16.dp)
                        )
                        // showDialog(tt, openAlertDialog)

                    }
                    Button(onClick = { openAlertDialog.value = true }) {
                        Text(text = "Open Dialog")
                    }
                    showDialog("hi", openAlertDialog)
                }


            }
        }
        DisposableEffect(Unit) {
            mainViewModel.fetchUsers()
            onDispose {}
        }

    }

    @Composable
    fun showDialog(data: String, openAlertDialog: MutableState<Boolean>) {
        var selectedCity = rememberSaveable {
            mutableStateOf(StudentItem("Madrid"))
        }
        if (openAlertDialog.value) {
            AlertDialogExample(
                onDismissRequest = {
                    openAlertDialog.value = false
                },
                onConfirmation = {
                    openAlertDialog.value = false
                    println("Confirmation registered") // Add logic here to handle confirmation.
                },
                dialogTitle = "Alert dialog example",
//            dialogText = "This is an example of an alert dialog with buttons.",
                dialogText = data,
                icon = Icons.Default.Info
            )
        }
    }

    //dialog
//@Composable
    @Composable
    fun AlertDialogExample(
        onDismissRequest: () -> Unit,
        onConfirmation: () -> Unit,
        dialogTitle: String,
        dialogText: String,
        icon: ImageVector,
    ) {
        AlertDialog(icon = {
            Icon(icon, contentDescription = "Example Icon")
        }, title = {
            Text(text = dialogTitle)
        }, text = {
            Text(text = dialogText)
        }, onDismissRequest = {
            onDismissRequest()
        }, confirmButton = {
            TextButton(onClick = {
                onConfirmation()
            }) {
                Text("Confirm")
            }
        }, dismissButton = {
            TextButton(onClick = {
                onDismissRequest()
            }) {
                Text("Dismiss")
            }
        })
    }
}