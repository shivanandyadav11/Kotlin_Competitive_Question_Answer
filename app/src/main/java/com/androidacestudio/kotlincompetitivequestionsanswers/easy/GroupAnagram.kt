package com.androidacestudio.kotlincompetitivequestionsanswers.easy

import java.util.Collections.addAll

/**
 * 49. Group Anagrams
 *
 * @Link: https://leetcode.com/problems/group-anagrams/description/
 *
 * Given an array of strings strs, group the anagrams together. You can return the answer in any order.
 *
 * Input: strs = ["eat","tea","tan","ate","nat","bat"]
 * Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * Explanation:
 *
 * There is no string in strs that can be rearranged to form "bat".
 * The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
 * The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
 *
 *
 * Input: strs = [""]
 * Output: [[""]]
 *
 *Input: strs = ["a"]
 * Output: [["a"]]
 */
class GroupAnagram {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = HashMap<String, MutableList<String>>()
        val result = mutableListOf<List<String>>()
        for (i in strs) {
            val st = i.toCharArray().sorted().joinToString("")
            if (map.containsKey(st)) {
                val mapValue: MutableList<String> = map.getValue(st)
                mapValue.add(i)
                map.put(st, mapValue)
            } else {
                map.put(st, mutableListOf(i))
            }
        }
        for (itr in map) {
            result.add(itr.value)
        }
        return result
    }
}

fun main() {
    val result1 =
        GroupAnagram().groupAnagrams(arrayOf<String>("eat", "tea", "tan", "ate", "nat", "bat"))
    println(result1)
}