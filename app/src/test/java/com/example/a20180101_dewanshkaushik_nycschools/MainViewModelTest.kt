package com.example.a20180101_dewanshkaushik_nycschools


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.MainViewModel
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.*

@ExperimentalCoroutinesApi
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private val topHeadlineRepository = mock(TopHeadlineRepository::class.java)
    private val testDispatcher = StandardTestDispatcher()
    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        viewModel = MainViewModel(topHeadlineRepository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // Reset the main dispatcher to avoid side effects
    }

    @Test
    fun `getData returns success state`() = runBlocking {
        // Arrange
        val studentItems = listOf(
            StudentItem("1", "John Doe"),
            StudentItem("2", "Jane Smith")
        )
        `when`(topHeadlineRepository.getTopHeadlines()).thenReturn(flow { emit(studentItems) })

        // Act
        viewModel.getData() // Call the method

        // Move the dispatcher forward to process the coroutine
        testDispatcher.scheduler.advanceUntilIdle()

        // Assert
        assertEquals(UiState.Success(studentItems), viewModel.uiState.value)
    }

    @Test
    fun `getData returns error state`() = runBlocking {
        // Arrange
        val errorMessage = "Network Error"
        `when`(topHeadlineRepository.getTopHeadlines()).thenReturn(flow { throw Exception(errorMessage) })

        // Act
        viewModel.getData() // Call the method

        // Move the dispatcher forward to process the coroutine
        testDispatcher.scheduler.advanceUntilIdle()

        // Assert
        assertEquals(UiState.Error(errorMessage), viewModel.uiState.value)
    }
}

