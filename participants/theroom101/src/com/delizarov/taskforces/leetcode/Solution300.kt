package com.delizarov.taskforces.leetcode

/*
* 300. Longest Increasing Subsequence
* https://leetcode.com/problems/longest-increasing-subsequence/
*
* */

class Solution300 {

    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }

        var r = 1

        for (i in (dp.size - 2 downTo 0)) {
            var m = dp[i]
            for (j in (i + 1 until dp.size)) {
                if (nums[i] >= nums[j]) continue

                m = Math.max(dp[i] + dp[j], m)
            }

            dp[i] = m
            r = Math.max(r, dp[i])
        }

        return r
    }
}