package com.delizarov.taskforces.leetcode

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream
import kotlin.test.assertEquals

class Solution300Test {

    private val solution: Solution300 by lazy { Solution300() }

    @ParameterizedTest
    @MethodSource("testSet")
    fun test(expected: Int, nums: IntArray) {
        assertEquals(expected, solution.lengthOfLIS(nums))
    }

    companion object {

        @JvmStatic
        fun testSet() = Stream.of(
            Arguments.of(4, intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)),
            Arguments.of(1, intArrayOf(2, 2))
        )
    }
}