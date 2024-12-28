package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class FlowViewModel(private val topHeadlineRepository: TopHeadlineRepository) : ViewModel() {

    val events = MutableSharedFlow<String>()

    init {
    }

    var count = 0

    // Emit events
    suspend fun emitEvent(event: String) {
       // while (count<50) {
            events.emit(event.toString())
         //   delay(1000)
          //  count++;
     //   }
    }

}
