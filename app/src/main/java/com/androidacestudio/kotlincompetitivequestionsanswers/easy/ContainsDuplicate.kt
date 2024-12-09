package com.androidacestudio.kotlincompetitivequestionsanswers.easy

/**
 * 217. Contains Duplicate
 * @Link: https://leetcode.com/problems/contains-duplicate/description/
 *
 * @Statement: Given an integer array nums, return true if any value appears at least twice in the array,
 * and return false if every element is distinct.
 *
 *
 * Input: nums = [1,2,3,1]
 * Output: true
 * Explanation:
 * The element 1 occurs at the indices 0 and 3.
 *
 *
 * Input: nums = [1,2,3,4]
 * Output: false
 * Explanation:
 * All elements are distinct.
 *
 *
 * Input: nums = [1,1,1,3,3,4,3,2,4,2]
 * Output: true
 **/
class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = mutableSetOf<Int>()
        for(itr in nums) {
            if(set.contains(itr)) {
                return true
            }
            set.add(itr)
        }
        return false
    }
}

fun main() {
    val result1 = ContainsDuplicate().containsDuplicate(listOf(1,2,3,1).toIntArray())
    val result2 = ContainsDuplicate().containsDuplicate(listOf(1,2,3,4).toIntArray())
    val result3 = ContainsDuplicate().containsDuplicate(listOf(1,1,1,3,3,4,3,2,4,2).toIntArray())
    println(result1)
    println(result2)
    println(result3)
}