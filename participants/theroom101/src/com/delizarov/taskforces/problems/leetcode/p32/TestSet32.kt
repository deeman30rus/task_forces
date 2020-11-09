package com.delizarov.taskforces.problems.leetcode.p32

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.sample
import com.delizarov.taskforces.domain.testSet

class Input32(
    val s: String
): InputData()

class Output32(
    val n: Int
): OutputData()

fun testSet32() = testSet {
    sample {
        input = Input32("()")
        expected = Output32(2)
    }

    sample {
        input = Input32("(()")
        expected = Output32(2)
    }

    sample {
        input = Input32(")()())")
        expected = Output32(4)
    }

    sample {
        input = Input32("")
        expected = Output32(0)
    }

    sample {
        input = Input32("(()((((()")
        expected = Output32(2)
    }

    sample {
        input = Input32("))))())()()(()")
        expected = Output32(4)
    }
}