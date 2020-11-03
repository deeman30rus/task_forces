package com.delizarov.taskforces.problems.leetcode.p1154

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.Problem
import com.delizarov.taskforces.domain.ResolutionException

class P1154: Problem() {

    private val dayInMonth = arrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)

    override fun solve(inputData: InputData): OutputData {
        val date = (inputData as? Input1154)?.date ?: error("Wrong input")

        return Output1154(dayOfYear(date))
    }

    override fun assertOutputValueCorrect(testNo: Int, expectedData: OutputData, actualData: OutputData) {
        val expected = (expectedData as? Output1154)?.dayOfYear ?: error("wrong output")
        val actual = (actualData as? Output1154)?.dayOfYear ?: error("wrong output")

        if (expected != actual) throw ResolutionException("testNo $testNo expected: $expected actual: $actual")
    }

    fun dayOfYear(date: String): Int {
        var isBisextile = date.year.rem(1000) == 0

        val dayInMonthSum = IntArray(dayInMonth.size)
        for (i in dayInMonth.indices) {
            if (i == 0) continue

            dayInMonthSum[i] = dayInMonthSum[i - 1] + dayInMonth[i]
        }

        if (!isBisextile) {
            isBisextile = date.year.rem(100) != 0 && date.year.rem(4) == 0
        }

        val month = date.month
        return date.day + dayInMonthSum[month - 1] + if (isBisextile && month > 2) 1 else 0
    }

    private val zeroChar: Int
        get() = '0'.toInt()

    private val String.year: Int
        get() = (get(0).toInt() - zeroChar) * 1000 + (get(1).toInt() - zeroChar) * 100 + (get(2).toInt() - zeroChar) * 10 + get(3).toInt() - zeroChar

    private val String.month: Int
        get() = (get(5).toInt() - zeroChar) * 10 + get(6).toInt() - zeroChar

    private val String.day: Int
        get() = (get(8).toInt() - zeroChar) * 10 + get(9).toInt() - zeroChar
}