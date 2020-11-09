package com.delizarov.taskforces.domain

import com.delizarov.taskforces.problems.leetcode.p1154.P1154
import com.delizarov.taskforces.problems.leetcode.p198.P198
import com.delizarov.taskforces.problems.leetcode.p605.P605
import com.delizarov.taskforces.problems.leetcode.p290.P290
import com.delizarov.taskforces.problems.leetcode.p32.P32
import com.delizarov.taskforces.problems.leetcode.p661.P661

class ProblemFactory {

    fun create(problemNo: String): Problem = when(problemNo) {
        "661" -> P661()
        "1154" -> P1154()
        "198" -> P198()
        "290" -> P290()
        "605" -> P605()
        "32" -> P32()
        else -> error("problem $problemNo I can't solve yet")
    }
}