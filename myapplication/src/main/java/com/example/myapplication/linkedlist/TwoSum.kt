package com.example.myapplication.linkedlist

class TwoSum {
}

fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>() // To store numbers and their indices
    for (i in nums.indices) {
        val complement = target - nums[i] // The number we need to find
        if (map.contains(complement)) {
            return intArrayOf(map[complement]!!, i) // Return the indices
        }
        map[nums[i]] = i // Store the current number and its index
    }
    throw IllegalArgumentException("No solution found") // This should never be reached with the given constraints
}
fun main() {
    val array = intArrayOf(2, 7, 11, 15)
    val print = twoSum(array,9)
    for(i in print) {
        println(i)
    }
}