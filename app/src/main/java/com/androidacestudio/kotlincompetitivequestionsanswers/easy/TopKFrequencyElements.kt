package com.androidacestudio.kotlincompetitivequestionsanswers.easy

/**
 * 347. Top K Frequent Elements
 *
 * @Link: https://leetcode.com/problems/top-k-frequent-elements/description/
 *
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 */

class TopKFrequencyElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        val bucket = MutableList(nums.size + 1) { mutableListOf<Int>() }
        val result = mutableListOf<Int>()
        for (itr in nums) {
            map.put(itr, map.getOrDefault(itr, 0) + 1)
        }

        for ((key, value) in map) {
            if (bucket[value].isNotEmpty().not()) {
                bucket[value] = mutableListOf<Int>()
            }
            bucket[value].add(key)
        }

        var counter = 0
        for (i in bucket.size - 1 downTo 0) {
            if (bucket[i].isNotEmpty()) {
                result.addAll(bucket[i])
                counter += bucket[i].size
            }
            if (counter == k) break
        }
        return result.toIntArray()
    }
}

fun main() {
    val result =
        TopKFrequencyElements().topKFrequent(mutableListOf<Int>(1, 1, 1, 2, 2, 3).toIntArray(), 2)

    for (i in result) {
        println(i)
    }

    val result1 = TopKFrequencyElements().topKFrequent(mutableListOf<Int>(1).toIntArray(), 1)

    for (i in result1) {
        println(i)
    }

    val result2 = TopKFrequencyElements().topKFrequent(
        mutableListOf<Int>(4, 1, -1, 2, -1, 2, 3).toIntArray(),
        2
    )

    for (i in result2) {
        println(i)
    }
}