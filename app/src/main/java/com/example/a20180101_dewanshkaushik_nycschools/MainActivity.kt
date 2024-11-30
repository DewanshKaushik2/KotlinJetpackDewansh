package com.example.a20180101_dewanshkaushik_nycschools

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.UiState
import javax.inject.Inject


//https://github.com/lubnamariyam/MovieList_Retrofit_API_In_Compose
//https://www.youtube.com/watch?v=bIVGIEMgc7Q&t=49s
class MainActivity : AppCompatActivity() {
    var MYTAG: String = "MainActivity"
    private fun injectDependencies() {
        DaggerActivityComponent.builder()
            .applicationComponent((application as MVVMApplication).applicationComponent)
            .activityModule(ActivityModule(this)).build().inject(this)
    }

    // inject viewmodel in activity
    @Inject
    lateinit var mainViewModel: MainViewModel

    @Inject
    lateinit var topHeadlineRepository: TopHeadlineRepository

//    private fun setupObserver() {
//        LaunchedEffect(Unit) {
//
//            repeatOnLifecycle(Lifecycle.State.STARTED) {
//                mainViewModel.uiState.collect {
//                    when (it) {
//                        is UiState.Success -> {
//                            val posts by mainViewModel.uiState.collectAsState()
//                            setData(posts)
//                        }
//
//                        is UiState.Error -> {
//                            TODO()
//                        }
//
//                        UiState.Loading -> {
//                            TODO()
//                        }
//                    }
//                }
//            }
//        }
//    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        injectDependencies()
        setContent {
            JetpackComposeAndroidExamplesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background
                ) {
                    val list = mutableListOf<StudentItem>()
                    Greeting(mainViewModel)

//                    LaunchedEffect(Unit) {
//                        GlobalScope.launch {
//                            val ss = async {
//                                printData({ result ->
//                                    //use result
//                                    println("mainhu" + result.toString())
//
//                                })
//                            }
//                                val dd = ss.await();
//                            Greeting(blogList = dd)
//                        }
//                    }
                }
            }
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

@Composable
fun Greeting(mainViewModel: MainViewModel) {
    // Log.e(TAG, blogList.toString())
    val posts by mainViewModel.posts
//    LazyColumn {
//        items(posts) { post ->
//            Text(text = post.academicopportunities1?:"null")
//        }
//    }
//    DisposableEffect(Unit) {
//        mainViewModel.fetchUsers()
//        onDispose {}
//    }
    //new column
    val context = LocalContext.current
    val openAlertDialog= rememberSaveable { mutableStateOf(false) }

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

@Composable
fun GreetingPreview() {
    JetpackComposeAndroidExamplesTheme {
        val list = mutableListOf<Student>()
//        list.add(Student("first student"))
//        list.add(Student("first student"))
//        list.add(Student("first student"))
//        list.add(Student("first student"))
//     //   Greeting("Android", list)

    }


}