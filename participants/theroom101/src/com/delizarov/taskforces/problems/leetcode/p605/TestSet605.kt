package com.delizarov.taskforces.problems.leetcode.p605

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.sample
import com.delizarov.taskforces.domain.testSet

class Input605(
    val flowerbed: IntArray,
    val n: Int
): InputData()

class Output605(
    val canPlant: Boolean
): OutputData()

fun testSet605() = testSet {
    sample {
        input = Input605(intArrayOf(1,0,0,0,1), 1)
        expected = Output605(true)
    }

    sample {
        input = Input605(intArrayOf(1,0,0,0,1), 2)
        expected = Output605(false)
    }

    sample {
        input = Input605(intArrayOf(0,0), 1)
        expected = Output605(true)
    }

    sample {
        input = Input605(intArrayOf(0,0,0), 2)
        expected = Output605(true)
    }

    sample {
        input = Input605(intArrayOf(1,0,0,0), 1)
        expected = Output605(true)
    }

    sample {
        input = Input605(intArrayOf(1,0,0,0), 2)
        expected = Output605(false)
    }

    sample {
        input = Input605(intArrayOf(0,1,0), 1)
        expected = Output605(false)
    }
}
