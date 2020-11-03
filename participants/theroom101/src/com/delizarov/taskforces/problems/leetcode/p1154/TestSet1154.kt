package com.delizarov.taskforces.problems.leetcode.p1154

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.sample
import com.delizarov.taskforces.domain.testSet

class Input1154(
    val date: String
): InputData()

class Output1154(
    val dayOfYear: Int
): OutputData()

fun testSet1154() = testSet {
    sample {
        input = Input1154("2019-01-09")
        expected = Output1154(9)
    }

    sample {
        input = Input1154("2019-02-10")
        expected = Output1154(41)
    }

    sample {
        input = Input1154("2003-03-01")
        expected = Output1154(60)
    }

    sample {
        input = Input1154("2004-03-01")
        expected = Output1154(61)
    }
}

