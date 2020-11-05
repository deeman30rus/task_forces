package com.delizarov.taskforces.domain

import com.delizarov.taskforces.problems.leetcode.p1154.P1154
import com.delizarov.taskforces.problems.leetcode.p1154.testSet1154
import com.delizarov.taskforces.problems.leetcode.p198.P198
import com.delizarov.taskforces.problems.leetcode.p198.testSet198
import com.delizarov.taskforces.problems.leetcode.p605.P605
import com.delizarov.taskforces.problems.leetcode.p605.testSet605
import com.delizarov.taskforces.problems.leetcode.p290.P290
import com.delizarov.taskforces.problems.leetcode.p290.testSet290
import com.delizarov.taskforces.problems.leetcode.p661.P661
import com.delizarov.taskforces.problems.leetcode.p661.testSet661

class TestDataRepository {

    inline fun <reified T: Problem> getDataFor(problem: T): TestData = when(problem) {
        is P661 -> testSet661()
        is P1154 -> testSet1154()
        is P198 -> testSet198()
        is P605 -> testSet605()
        is P290 -> testSet290()
        else -> error("Unknown problem type ${problem::class}")
    }
}