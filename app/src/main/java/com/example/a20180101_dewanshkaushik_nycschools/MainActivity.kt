package com.example.a20180101_dewanshkaushik_nycschools

//import com.example.a20180101_dewanshkaushik_nycschools.ui.theme._20180101DewanshKaushikNYCSchoolsTheme
import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.a20180101_dewanshkaushik_nycschools.component.DaggerActivityComponent
import com.example.a20180101_dewanshkaushik_nycschools.module.ActivityModule
import com.example.a20180101_dewanshkaushik_nycschools.ui.theme.JetpackComposeAndroidExamplesTheme
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import javax.inject.Inject


//https://github.com/lubnamariyam/MovieList_Retrofit_API_In_Compose
//https://www.youtube.com/watch?v=bIVGIEMgc7Q&t=49s
class MainActivity : AppCompatActivity() {
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
    //  val mainViewModel by viewModels<MainViewModel>()


    //function to show  data in list
    @Composable
    fun setData(blogList: List<StudentItem>) {
        Greeting(blogList)
    }

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
// 9837563914
//    @Composable
//    fun PostList(viewModel: MainViewModel) {
//        val posts by viewModel.posts.collectAsState()
//        LazyColumn {
//            items(posts) { post ->
//                Text(text = post)
//            }
//        }
//        DisposableEffect(Unit) {
//            viewModel.getPosts()
//            onDispose {}
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
                    Greeting(list)
                    Greeting(blogList = mainViewModel.posts)
                    mainViewModel.fetchUsers()
                    LaunchedEffect(Unit) {
                        GlobalScope.launch {
                          val ss=  async {
                                printData({ result ->
                                    //use result
                                    println("mainhu"+result.toString())

                                })
                            }

                        }
                    }
                }
            }
        }
    }

   suspend fun printData(myCallback: (result: ArrayList<StudentItem>?) -> Unit) {
        var list:ArrayList<StudentItem>
        topHeadlineRepository.getTopHeadlines().collect { value ->
            list = value.toList() as ArrayList<StudentItem>
            myCallback.invoke(list)
        }
    }
}

@Composable
fun Greeting(blogList: List<StudentItem>) {
//    val myData = listOf("Hello,", "world!")
    LazyColumn {
        items(blogList) { item ->

            val context = LocalContext.current
            Column {
                for (blog in blogList) {
                    Card(
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                            .clickable(onClick = {
                                Toast
                                    .makeText(
                                        context, "Author: ${blog.academicopportunities1}", Toast.LENGTH_SHORT
                                    )
                                    .show()
                            }),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant,
                        )
                    ) {
                        Text(
                            blog.academicopportunities1, style = TextStyle(
                                fontSize = 16.sp, textAlign = TextAlign.Center
                            ), modifier = Modifier.padding(16.dp)
                        )
                    }
                }
            }

        }
    }
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
}

@Preview(showBackground = true)
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