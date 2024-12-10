package com.androidacestudio.kotlincompetitivequestionsanswers.easy

/**
 *
 * 242. Valid Anagram
 *
 * @link: https://leetcode.com/problems/valid-anagram/description/
 *
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 *
 *
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Input: s = "rat", t = "car"
 * Output: false
 *
 */
class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        val mapS = hashMapOf<Char, Int>()

        if (s.isEmpty() && t.isEmpty()) {
            return true
        }

        if (s.length != t.length) {
            return false
        }

        for (itr in 0..s.length - 1) {
            val ch = s[itr]
            if (mapS.contains(ch)) {
                val mapValue = mapS.getValue(ch)
                mapS.put(ch, mapValue + 1)
            } else {
                mapS.put(ch, 1)
            }
        }
        for (itr in 0..t.length - 1) {
            val ch = t[itr]
            if (mapS.contains(ch)) {
                val mapValue = mapS.getValue(ch)
                if (mapValue == 1) {
                    mapS.remove(ch)
                } else {
                    mapS.put(ch, mapValue - 1)
                }
            }
        }

        return mapS.isEmpty()
    }
}

fun main() {
    val result1 = ValidAnagram().isAnagram("anagram", "nagaram")
    val result2 = ValidAnagram().isAnagram("rat", "car")
    val result3 = ValidAnagram().isAnagram("a", "ab")
    println(result1)
    println(result2)
    println(result3)
}