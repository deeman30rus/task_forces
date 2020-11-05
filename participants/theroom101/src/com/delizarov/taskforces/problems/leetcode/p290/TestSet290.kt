package com.delizarov.taskforces.problems.leetcode.p290

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.sample
import com.delizarov.taskforces.domain.testSet

class Input290(
    val pattern: String,
    val str: String
) : InputData()

class Output290(
    val match: Boolean
) : OutputData()

fun testSet290() = testSet {
    sample {
        input = Input290("abba", "dog cat cat dog")
        expected = Output290(true)
    }

    sample {
        input = Input290("abba", "dog cat cat fish")
        expected = Output290(false)
    }

    sample {
        input = Input290("aaaa", "dog cat cat dog")
        expected = Output290(false)
    }

    sample {
        input = Input290("abba", "dog dog dog dog")
        expected = Output290(false)
    }
}
