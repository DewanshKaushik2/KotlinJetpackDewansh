//package com.example.a20180101_dewanshkaushik_nycschools.viewmodels
//
//
//import app.cash.turbine.test
//import com.example.a20180101_dewanshkaushik_nycschools.TopHeadlineRepository
//import com.example.a20180101_dewanshkaushik_nycschools.models.StudentDetail
//import com.example.a20180101_dewanshkaushik_nycschools.models.StudentDetailItem
//import com.example.a20180101_dewanshkaushik_nycschools.models.UiStateSecond
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.ExperimentalCoroutinesApi
//import kotlinx.coroutines.flow.flow
//import kotlinx.coroutines.test.*
//import org.junit.jupiter.api.AfterEach
//import org.junit.jupiter.api.Assertions.*
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.mockito.Mockito.*
//import org.mockito.kotlin.mock
//
//@ExperimentalCoroutinesApi
//class FlowViewModelTest {
//
//    private val testDispatcher = StandardTestDispatcher()
//    private lateinit var viewModel: FlowViewModel
//    private val mockRepository: TopHeadlineRepository = mock()
//
//    @BeforeEach
//    fun setUp() {
//        Dispatchers.setMain(testDispatcher)
//        viewModel = FlowViewModel(mockRepository)
//    }
//
//    @AfterEach
//    fun tearDown() {
//        Dispatchers.resetMain()
//    }
//
//    @Test
//    fun `fetchUsers should update uiState with success`() = runTest {
//        // Arrange
//        val mockData = StudentDetail(listOf(StudentDetailItem("John Doe", "123"
//        ,""
//        ,""
//        ,""
//        ,""
//        )))
//        `when`(mockRepository.getCityDetails()).thenReturn(flow { emit(mockData) })
//
//        // Act
//        viewModel.fetchUsers()
//        testDispatcher.scheduler.advanceUntilIdle()
//
//        // Assert
//        assertTrue(viewModel.uiState.value is UiStateSecond.Success)
//        val successState = viewModel.uiState.value as UiStateSecond.Success<StudentDetail>
//        assertEquals(mockData, successState.data)
//    }
//
//    @Test
//    fun `fetchUsers should update uiState with error when exception occurs`() = runTest {
//        // Arrange
//        val exceptionMessage = "Network error"
//        `when`(mockRepository.getCityDetails()).thenReturn(flow { throw RuntimeException(exceptionMessage) })
//
//        // Act
//        viewModel.fetchUsers()
//        testDispatcher.scheduler.advanceUntilIdle()
//
//        // Assert
//        assertTrue(viewModel.uiState.value is UiStateSecond.Error)
//        val errorState = viewModel.uiState.value as UiStateSecond.Error
//        assertEquals(exceptionMessage, errorState.message)
//    }
//
//    @Test
//    fun `emitEvent should emit the correct event`() = runTest {
//        // Arrange
//        val testEvent = "Test Event"
//
//        // Act
//        viewModel.events.test {
//            viewModel.emitEvent(testEvent)
//
//            // Assert
//            assertEquals(testEvent, awaitItem())
//            cancelAndIgnoreRemainingEvents()
//        }
//    }
//}
