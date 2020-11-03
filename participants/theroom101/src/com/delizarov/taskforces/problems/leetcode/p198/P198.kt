package com.delizarov.taskforces.problems.leetcode.p198

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.Problem
import com.delizarov.taskforces.domain.ResolutionException
import kotlin.math.max

/*
* https://leetcode.com/problems/house-robber/
* */

class P198 : Problem() {

    override fun solve(inputData: InputData): OutputData {
        val nums = (inputData as? Input198)?.nums ?: error("Wrong input")

        return Output198(rob(nums))

    }

    override fun assertOutputValueCorrect(testNo: Int, expectedData: OutputData, actualData: OutputData) {
        val expected = (expectedData as? Output198)?.sum ?: error("wrong output")
        val actual = (actualData as? Output198)?.sum ?: error("wrong output")

        if (expected != actual) throw ResolutionException("testNo $testNo expected: $expected actual: $actual")
    }

    fun rob(nums: IntArray): Int {
        val gain = IntArray(nums.size)

        if (nums.isEmpty()) return 0
        gain[0] = nums[0]

        if (nums.size > 1) gain[1] = max(gain[0], nums[1])

        if (nums.size > 2) gain[2] = max(nums[0] + nums[2], nums[1])

        for (i in 3 until nums.size) {
            gain[i] = max(
                gain[i - 1],
                max(gain[i - 2] + nums[i], gain[i - 3] + nums[i])
            )
        }

        return gain.last()
    }
}