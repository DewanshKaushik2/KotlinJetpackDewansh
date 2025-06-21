package com.example.myapplication.linkedlist


object MultiplyArrayExceptSelf {
    fun multiplyExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val result = IntArray(n)

        // Step 1: Compute the product of all elements to the left of the current element
        var leftProduct = 1
        for (i in 0 until n) {
            result[i] = leftProduct // Store left product
            leftProduct = leftProduct * nums[i] // Update left product for next element
        }

        // Step 2: Compute the product of all elements to the right of the current element
        var rightProduct = 1
        for (i in n - 1 downTo 0) {
            result[i] = result[i] * rightProduct // Multiply with right product
            rightProduct  = rightProduct * nums[i] // Update right product for next element
        }
        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val nums = intArrayOf(1, 2, 3, 4)
        val result = multiplyExceptSelf(nums)

        // Print the result
        for (i in result) {
            print("$i ")
        }
    }
}


fun main() {
    print("")
    mera()
}

fun mera() {
    var list = mutableListOf<String>()
    list.add("hi")
    println(list.get(0))

    var list2 = ArrayList<String>()
    list2.add("hi")
    println(list2.get(0))

    val array = intArrayOf(1,2,3,4,5)
    println(array[4])

    // list[0] = ""
    list.forEach {
        println(it)
    }
    /*list.set(1, "")
    list.get(1)
*/
}
