package com.example.a20180101_dewanshkaushik_nycschools

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.a20180101_dewanshkaushik_nycschools.model.ApiUser
import com.example.a20180101_dewanshkaushik_nycschools.models.ApiHelper
import com.example.a20180101_dewanshkaushik_nycschools.models.DatabaseHelper
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.SingleNetworkCallViewModel
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.UiState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.jupiter.api.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.verify
import org.mockito.junit.MockitoJUnitRunner
import org.mockito.kotlin.doThrow

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
open class SingleNetworkCallViewModelTest {

    @get:Rule
    val testInstantTaskExecutorRule: TestRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    @Mock
    private lateinit var apiHelper: ApiHelper

    @Mock
    private lateinit var databaseHelper: DatabaseHelper

    @Mock
    private lateinit var uiStateObserver: Observer<UiState<List<ApiUser>>>

    @Before
    fun setUp() {
        // do something if required
    }

    @Test
    open fun givenServerResponse200_whenFetch_shouldReturnSuccess() {
        testCoroutineRule.runBlockingTest {
            doReturn(emptyList<ApiUser>())
                .`when`(apiHelper)
                .getUsers()
            val viewModel = SingleNetworkCallViewModel(apiHelper, databaseHelper)
            viewModel.getUiState().observeForever(uiStateObserver)
            verify(apiHelper).getUsers()
            verify(uiStateObserver).onChanged(UiState.Success2(ApiUser()))
            viewModel.getUiState().removeObserver(uiStateObserver)
        }
    }

    @Test
    open fun givenServerResponseError_whenFetch_shouldReturnError() {
        testCoroutineRule.runBlockingTest {
            val errorMessage = "Error Message For You"
            doThrow(RuntimeException(errorMessage))
                .`when`(apiHelper)
                .getUsers()
            val viewModel = SingleNetworkCallViewModel(apiHelper, databaseHelper)
            viewModel.getUiState().observeForever(uiStateObserver)
            verify(apiHelper).getUsers()
            verify(uiStateObserver).onChanged(
                UiState.Error(RuntimeException(errorMessage).toString())
            )
            viewModel.getUiState().removeObserver(uiStateObserver)
        }
    }

    @After
    fun tearDown() {
        // do something if required
    }

}
