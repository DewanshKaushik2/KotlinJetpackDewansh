package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20180101_dewanshkaushik_nycschools.model.ApiUser
import com.example.a20180101_dewanshkaushik_nycschools.models.ApiHelper
import com.example.a20180101_dewanshkaushik_nycschools.models.DatabaseHelper
import kotlinx.coroutines.launch

class SingleNetworkCallViewModel(
    private val apiHelper: ApiHelper,
    private val dbHelper: DatabaseHelper
) : ViewModel() {

    private val uiState = MutableLiveData<UiState<List<ApiUser>>>()

    init {
        fetchUsers()
    }

    private fun fetchUsers() {
        viewModelScope.launch {
            uiState.postValue(UiState.Loading)
            try {
                val usersFromApi = apiHelper.getApiUser()
                      uiState.postValue(UiState.Success2(usersFromApi))
            } catch (e: Exception) {
                uiState.postValue(UiState.Error(e.toString()))
            }
        }
    }

    fun getUiState(): LiveData<UiState<List<ApiUser>>> {
        return uiState
    }

}
