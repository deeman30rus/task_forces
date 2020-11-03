package com.delizarov.taskforces.problems.leetcode.p661

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.Problem
import com.delizarov.taskforces.domain.ResolutionException
import kotlin.math.max
import kotlin.math.min

/*
* https://leetcode.com/problems/image-smoother/
*
* Given a 2D integer matrix M representing the gray scale of an image,
* you need to design a smoother to make the gray scale of each cell becomes
* the average gray scale (rounding down) of all the 8 surrounding cells and itself.
* If a cell has less than 8 surrounding cells, then use as many as you can.
*
* */

class P661 : Problem() {

    override fun solve(inputData: InputData): OutputData {
        val input = (inputData as? Input661)?.m ?: error("Wrong data")

        return Output661(imageSmoother(input))
    }

    override fun assertOutputValueCorrect(testNo: Int, expectedData: OutputData, actualData: OutputData) {
        val expected = (expectedData as? Output661)?.m ?: error("Wrong data")
        val actual = (actualData as? Output661)?.m ?: error("Wrong data")

        for (r in expected.indices) {
            for (c in expected[0].indices) {
                if (expected[r][c] != actual[r][c]) {
                    throw ResolutionException(
                        """ 
                        Result validation mismatch 
                        expected: ${expected.joinToString { row -> row.joinToString(",") } }
                        
                        actual: ${actual.joinToString { row -> row.joinToString(",") } }
                    """.trimIndent()
                    )
                }
            }
        }
    }

    private fun imageSmoother(M: Array<IntArray>): Array<IntArray> {
        val width = M[0].size
        val height = M.size

        val out = Array(height) { IntArray(width) { 0 } }

        for (r in 0 until height) {
            for (c in 0 until width) {
                out[r][c] = M.smooth(r, c)
            }
        }

        return out
    }

    private fun Array<IntArray>.smooth(row: Int, col: Int): Int {
        var count = 0
        var sum = 0

        val startCol = max(col - 1, 0)
        val finCol = min(col + 1, get(0).size - 1)

        val startRow = max(row - 1, 0)
        val finRow = min(row + 1, size - 1)

        for (r in (startRow .. finRow)) {
            for (c in (startCol .. finCol)) {
                sum += this[r][c]
                count++
            }
        }

        return (sum / count.toFloat()).toInt()
    }
}