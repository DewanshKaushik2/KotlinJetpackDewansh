package com.example.a20180101_dewanshkaushik_nycschools.viewmodels

import app.cash.turbine.test
import com.example.a20180101_dewanshkaushik_nycschools.StudentItem
import org.junit.jupiter.api.Assertions.*

import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.test.*
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*
import org.mockito.Mockito.mock
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private lateinit var topHeadlineRepository: TopHeadlineRepository
    private lateinit var viewModel: MainViewModel

    @BeforeEach
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        topHeadlineRepository = mock()
        viewModel = MainViewModel(topHeadlineRepository)
    }

    @AfterEach
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchUsers should update uiState and posts when successful`() = runTest {
        // Arrange
        val mockStudentItems = listOf(
            StudentItem("Student1"
            ,""
            ,""
            ,""
            ,""
            ,""

            ),
            StudentItem("Student2"
                ,""
                ,""
                ,""
                ,""
                ,""
            )
        )
        whenever(topHeadlineRepository.getTopHeadlines()).thenReturn(
            MutableStateFlow(mockStudentItems)
        )

        // Act
        viewModel.fetchUsers()
        advanceUntilIdle()

        // Assert
        assertTrue(viewModel.loading.value == false)
        assertEquals(mockStudentItems, viewModel.posts.value)
        assertTrue(viewModel.uiState.value is UiState.Success)
        assertEquals(mockStudentItems, (viewModel.uiState.value as UiState.Success).data)
    }

    @Test
    fun `fetchUsers should update uiState to Error on failure`() = runTest {
        // Arrange
        val mockError = RuntimeException("Network error")
        whenever(topHeadlineRepository.getTopHeadlines()).thenAnswer {
            throw mockError
        }

        // Act
        viewModel.fetchUsers()
        advanceUntilIdle()

        // Assert
        assertTrue(viewModel.loading.value == false)
        assertTrue(viewModel.uiState.value is UiState.Error)
        assertEquals(mockError.toString(), (viewModel.uiState.value as UiState.Error))
    }

    @Test
    fun `emitEvent should emit events correctly`() = runTest {
        // Arrange
        val event = "Test Event"

        // Act
        viewModel.events.test {
            viewModel.emitEvent(event)
            // Assert
            assertEquals(event, awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }

    @Test
    fun `startTimer should emit countdown values`() = runTest {
        // Arrange
        val duration = 5

        // Act
        viewModel.startTimer(duration).test {
            for (time in duration downTo 0) {
                assertEquals(time, awaitItem())
            }
            awaitComplete()
        }
    }

    @Test
    fun `myflow emits values as expected`() = runTest {
        // Act
        viewModel.myflow.test {
            assertEquals("hi", awaitItem())
            assertEquals("hi", awaitItem())
            cancelAndIgnoreRemainingEvents()
        }
    }
}

private fun Any.thenReturn(mutableStateFlow: MutableStateFlow<List<StudentItem>>) {
    TODO("Not yet implemented")
}
