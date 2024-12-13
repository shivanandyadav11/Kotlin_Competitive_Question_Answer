package com.androidacestudio.kotlincompetitivequestionsanswers.easy

/**
 * 36. Valid Sudoku
 *
 * https://leetcode.com/problems/valid-sudoku/description/
 *
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 *
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 *
 */
class IsValidSudoku {

    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val set = mutableSetOf<String>()
        for (row in 0..8) {
            for (column in 0..8) {
                val value = board[row][column].toString()
                if (value != ".") {
                    val rowCell = "row $row $value"
                    val columnCell = "column $column $value"
                    val boxCell = "box ${(row / 3) * 3 + (column / 3)} $value"

                    if (set.contains(rowCell) || set.contains(columnCell) || set.contains(boxCell)) {
                        return false
                    }
                    set.add(rowCell)
                    set.add(columnCell)
                    set.add(boxCell)
                }
            }
        }
        return true
    }
}

fun main() {
    val sudokuBoard: Array<CharArray> = arrayOf(
        charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
        charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
        charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
        charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
        charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
        charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
        charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
        charArrayOf('.', '.', '.', '.', '4', '1', '9', '.', '5'),
        charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '.')
    )
    val result = IsValidSudoku().isValidSudoku(sudokuBoard)
    println(result)
}
