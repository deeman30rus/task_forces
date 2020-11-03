package com.delizarov.taskforces.domain

import com.delizarov.taskforces.problems.leetcode.p1154.P1154
import com.delizarov.taskforces.problems.leetcode.p1154.testSet1154
import com.delizarov.taskforces.problems.leetcode.p198.P198
import com.delizarov.taskforces.problems.leetcode.p198.testSet198
import com.delizarov.taskforces.problems.leetcode.p661.P661
import com.delizarov.taskforces.problems.leetcode.p661.testSet661

class TestDataRepository {

    inline fun <reified T: Problem> getDataFor(problem: T): TestData = when(problem) {
        is P661 -> testSet661()
        is P1154 -> testSet1154()
        is P198 -> testSet198()
        else -> error("Unknown problem type ${problem::class}")
    }
}