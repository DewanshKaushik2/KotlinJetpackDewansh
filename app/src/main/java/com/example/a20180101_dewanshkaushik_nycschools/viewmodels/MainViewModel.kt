package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20180101_dewanshkaushik_nycschools.StudentItem
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(private val topHeadlineRepository: TopHeadlineRepository) :
    ViewModel() {
    private val _uiState = MutableStateFlow<UiState<StudentItem>>(UiState.Loading)
    val uiState: StateFlow<UiState<StudentItem>> = _uiState

    var counterState = MutableStateFlow(1)

    var loading = MutableStateFlow(false);

    val posts: MutableState<List<StudentItem>> = mutableStateOf(emptyList())
    val myflow = MutableSharedFlow<String>(replay = 7)

    //function to get data from server
    init {
        runMethod()
        fetchUsers()
        viewModelScope.launch {
            myflow.emit("hi")
            myflow.emit("hi")
        }
    }

    fun runMethod() {
        var count = 0
        viewModelScope.launch {
            while (true) {
             //d   println(count++)
                delay(1000)
            }
        }
    }

    private val _users = mutableStateListOf<StudentItem>()
    val users: List<StudentItem> = _users

    fun fetchUsers() {
        //   val coldFlow: Flow<Int> = hotToColdFlow(hotFlow)

        loading.value = true;
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val response = topHeadlineRepository.getTopHeadlines()
                response.catch { e ->
                    _uiState.value = UiState.Error(e.toString())
                    e.printStackTrace()
                }.collect { value ->
                    //   val list
                    _uiState.value = UiState.Success(value)
                    posts.value = UiState.Success<StudentItem>(value).data
                    loading.value = false;
                }
            } catch (e: Exception) {
                e.printStackTrace()
                loading.value = false;
            }
        }
    }

     fun startTimer(durationInSeconds: Int): Flow<Int> {
        return flow {
            for (time in durationInSeconds downTo 0) {
                emit(time) // Emit the current time
                delay(1000L) // Wait for 1 second
            }
        }.onEach { time ->
            // Optional: Perform an action with each tick
        }.onCompletion {
            // Optional: Handle timer completion
        }
    }

    fun myviewMethod() {
        val head = topHeadlineRepository.myMethod()
        viewModelScope.launch {
            head.collect { value ->
          //d      println(value)
            }
        }
    }

    //this method will convert hotflow into cold flow
    fun hottocoldflow(hotflow: Flow<String>): Flow<String> {
        return flow {
            hotflow.collect { value ->
                emit(value)
            }
        }
    }
    // Define a MutableSharedFlow
    private val _events = MutableSharedFlow<String>(
        replay = 10, // Replay the last emitted value to new collectors
        extraBufferCapacity = 10 // Allow a buffer of 10 events
    )


    // Expose SharedFlow to observers
    val events = _events.asSharedFlow()

    // Emit events
    suspend fun emitEvent(event: String) {
        _events.emit(event)
    }
}
