package com.delizarov.taskforces.problems.leetcode.p605

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.Problem
import com.delizarov.taskforces.domain.ResolutionException

class P605: Problem() {

    override fun solve(inputData: InputData): OutputData {
        val input605 = inputData as? Input605 ?: error("Wrong input 605")

        return Output605(canPlaceFlowers(input605.flowerbed, input605.n))
    }

    override fun assertOutputValueCorrect(testNo: Int, expectedData: OutputData, actualData: OutputData) {
        val expected = (expectedData as? Output605)?.canPlant ?: error("Wrong output 605")
        val actual = (actualData as? Output605)?.canPlant ?: error("Wrong output 605")

        if (expected != actual) throw ResolutionException("testNo $testNo expected: $expected actual $actual")
    }

    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var i = 0
        var count = 0
        while (i < flowerbed.size) {
            when {
                flowerbed[i] == 0 && (i == flowerbed.size - 1 || flowerbed[i + 1] == 0) -> {
                    count++
                    i += 2
                }
                flowerbed[i] == 1 -> { i += 2 }
                else -> i++
            }
        }

        return count >= n
    }
}