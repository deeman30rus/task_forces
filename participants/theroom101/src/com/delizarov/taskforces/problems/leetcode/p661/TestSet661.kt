package com.delizarov.taskforces.problems.leetcode.p661

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.sample
import com.delizarov.taskforces.domain.testSet

class Input661(
    val m: Array<IntArray>
): InputData()

class Output661(
    val m: Array<IntArray>
): OutputData()

fun testSet661() = testSet {
    sample {
        input = input1()
        expected = expected1()
    }

    sample {
        skipCheck = true
        input = input2()
    }
}

// 1 --------------------

private fun input1() = Input661(
    arrayOf(
        IntArray(3) { 1 },
        IntArray(3) { i -> (i + 1).rem(2) },
        IntArray(3) { 1 }
    )
)

private fun expected1() = Output661(
    arrayOf(
        IntArray(3) { 0 },
        IntArray(3) { 0 },
        IntArray(3) { 0 }
    )
)

// 2 --------------------

// [[2,3,4],[5,6,7],[8,9,10],[11,12,13],[14,15,16]]

private fun input2() = Input661(
    arrayOf(
        IntArray(3) { i -> i + 2 },
        IntArray(3) { i -> i + 5 },
        IntArray(3) { i -> i + 8 },
        IntArray(3) { i -> i + 11 },
        IntArray(3) { i -> i + 14 }
    )
)