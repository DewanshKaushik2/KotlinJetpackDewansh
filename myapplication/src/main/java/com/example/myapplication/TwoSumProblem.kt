package com.example.myapplication

class TwoSumProblem() {



    fun myfunc(first: Any){
        println(first)
    }

}
fun twoSum(nums: IntArray, target: Int): IntArray {
    val map = mutableMapOf<Int, Int>() // Map to store the number and its index
    for (i in nums.indices) {
        val complement = target - nums[i]  // The complement number we need to find
        if (map.containsKey(complement)) {
            return intArrayOf(map[complement]!!, i)  // Return the indices of the two numbers
        }
        map[nums[i]] = i  // Store the number and its index
    }
    throw IllegalArgumentException("No two sum solution")  // If no solution is found
}
fun main() {
    val str = "kotlin is awesome, kotlin is fun"
    val substring = "kotlin"

    val frequency = Regex(Regex.escape(substring)).findAll(str).count()
    println("Frequency of '$substring': $frequency")  // Output: Frequency of 'kotlin': 2
}

/*fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9
    val result = twoSum(nums, target)
    println("Indices of the two numbers are: [${result[0]}, ${result[1]}]")
}*/






