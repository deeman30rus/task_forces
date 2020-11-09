package com.delizarov.taskforces.problems.leetcode.p32

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.Problem
import com.delizarov.taskforces.domain.ResolutionException
import java.util.*
import kotlin.math.max

class P32 : Problem() {

    override fun solve(inputData: InputData): OutputData {
        val input32 = inputData as? Input32 ?: error("Wrong input 32")

        return Output32(longestValidParentheses(input32.s))
    }

    override fun assertOutputValueCorrect(testNo: Int, expectedData: OutputData, actualData: OutputData) {
        val expected = (expectedData as? Output32)?.n ?: error("Wrong output 32")
        val actual = (actualData as? Output32)?.n ?: error("Wrong output 32")

        if (expected != actual) throw ResolutionException("testNo $testNo expected: $expected actual: $actual")
    }

    fun longestValidParentheses(s: String): Int {
        val stack = LinkedList<Int>()
        stack.add(0)

        var r = 0

        for (p in s) {
            if (p == '(') {
                stack.addLast(0)
            } else {
                if (stack.size == 1) {
                    r = max(r, stack.last())
                    stack.resetTail(0)

                    continue
                }

                val top = stack.removeLast()

                stack.resetTail(stack.last + top + 2)
                r = max(r, stack.last())
            }
        }

        return r
    }

    private fun LinkedList<Int>.resetTail(element: Int) {
        set(size - 1, element)
    }
}