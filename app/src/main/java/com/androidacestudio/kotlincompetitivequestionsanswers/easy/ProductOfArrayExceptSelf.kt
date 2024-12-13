package com.androidacestudio.kotlincompetitivequestionsanswers.easy

/**
 * 238. Product of Array Except Self
 *
 * @Link: https://leetcode.com/problems/product-of-array-except-self/description/
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 *
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
class ProductOfArrayExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {
        val result = MutableList<Int>(nums.size) { 1 }
        var leftProduct = 1
        var rightProduct = 1

        for(i in 0..nums.size-1) {
            result[i] = leftProduct
            leftProduct *= nums[i]
        }

        for(j in nums.size -1 downTo 0) {
            result[j] *= rightProduct
            rightProduct *= nums[j]
        }

        return result.toIntArray()
    }
}

fun main() {
    val result = ProductOfArrayExceptSelf().productExceptSelf(mutableListOf(1,2,3,4).toIntArray())
    for(i in result) {
        print("$i ")
    }
    println()
}