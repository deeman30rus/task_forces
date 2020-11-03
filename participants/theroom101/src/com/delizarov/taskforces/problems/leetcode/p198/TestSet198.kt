package com.delizarov.taskforces.problems.leetcode.p198

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.sample
import com.delizarov.taskforces.domain.testSet

class Input198(
    val nums: IntArray
): InputData()

class Output198(
    val sum: Int
): OutputData()

fun testSet198() = testSet {
    sample {
        input = Input198(intArrayOf(1,2,3,1))
        expected = Output198(4)
    }

    sample {
        input = Input198(intArrayOf(2,7,9,3,1))
        expected = Output198(12)
    }
}
