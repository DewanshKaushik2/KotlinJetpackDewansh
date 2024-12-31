package com.example.a20180101_dewanshkaushik_nycschools.activities

import androidx.lifecycle.lifecycleScope
import com.example.a20180101_dewanshkaushik_nycschools.viewmodels.FlowViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.verify

@OptIn(ExperimentalCoroutinesApi::class)
class FlowActivityTest {

    private lateinit var flowActivity: FlowActivity
    private lateinit var flowViewModel: FlowViewModel

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)

        // Mock FlowViewModel
        flowViewModel = mockk(relaxed = true)

        // Mock FlowActivity
        flowActivity = spyk(FlowActivity(), recordPrivateCalls = true)
        every { flowActivity.flowViewModel } returns flowViewModel

        // Mock lifecycleScope
        every { flowActivity.lifecycleScope } returns testScope
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `test FlowActivity lifecycle launches flows`() = testScope.runTest {
        // Prepare the FlowViewModel to emit values
        val eventsFlow = MutableSharedFlow<String>()
        every { flowViewModel.events } returns eventsFlow.asSharedFlow()

        // Call onCreate to trigger logic
        flowActivity.onCreate(null)

        // Verify emitEvent is called
        verify(exactly = 1) { flowViewModel.emitEvent("1") }
        verify(exactly = 1) { flowViewModel.emitEvent("2") }
        verify(exactly = 1) { flowViewModel.emitEvent("3") }

        // Emit values from the flow
        testScope.launch {
            eventsFlow.emit("test_event_1")
            eventsFlow.emit("test_event_2")
        }

        // Advance the coroutine dispatcher to process events
        testDispatcher.scheduler.advanceUntilIdle()

        // Verify log calls (replace Log.e with a mock if necessary)
        verify { flowActivity.TAG }
    }

    @Test
    fun `test GlobalScope collects shared flow`() = testScope.runTest {
        val sharedFlow = MutableSharedFlow<Int>()

        // Replace GlobalScope with testScope for testing
        testScope.launch {
            sharedFlow.emit(1)
            sharedFlow.emit(2)
            sharedFlow.emit(3)
        }

        val collector = mutableListOf<Int>()
        testScope.launch {
            sharedFlow.collect { value ->
                collector.add(value)
            }
        }

        testDispatcher.scheduler.advanceUntilIdle()

        // Verify all collected values
        assert(collector == listOf(1, 2, 3))
    }
}
