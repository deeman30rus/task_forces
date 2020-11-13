import java.lang.AssertionError

// Longest Increasing Subsequence
// https://leetcode.com/problems/longest-increasing-subsequence/

/**
 * Given an unsorted array of integers,
 * find the length of longest increasing subsequence
 */
fun longestIncreasingSubsequence(arr: IntArray): Int {
    val seqSizes = IntArray(arr.size) { 0 }

    for (i in arr.lastIndex downTo 0) {
        var maxSeqSize = 0

        for (j in i+1 until arr.size) {
            if (arr[i] < arr[j] && maxSeqSize < seqSizes[j]) {
                maxSeqSize = seqSizes[j]
            }
        }

        seqSizes[i] = maxSeqSize + 1
    }

    return seqSizes.max() ?: 1
}

val cases = mapOf(
    intArrayOf(10,9,2,5,3,7,101,18) to 4,
    intArrayOf(101,102,103,104,105,1,2,3,4,106,5) to 6,
    intArrayOf(101,102,103,104,105,11,12,13,14,106,15,1,2,3) to 6,
    intArrayOf(1,101,102,103,104,105,11,12,13,14,106,15,2,3,4,5,6,7,8) to 8,
    intArrayOf(10,20,3,40,50,60,70,80) to 7,
    intArrayOf(101,102,103,104,99,105) to 5,
    intArrayOf(10,101,102,103,104,99,105,20,3,40,50,60,70,80) to 7
)

cases.toList().forEachIndexed { i, (arr, expectedResult) ->
    val result = longestIncreasingSubsequence(arr)
    if (result != expectedResult) {
        throw AssertionError("Case: $i; Expected: ${expectedResult}; actual: $result")
    }
}

println("Vse OK!")


