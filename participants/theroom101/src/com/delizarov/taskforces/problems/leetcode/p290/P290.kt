package com.delizarov.taskforces.problems.leetcode.p290

import com.delizarov.taskforces.domain.InputData
import com.delizarov.taskforces.domain.OutputData
import com.delizarov.taskforces.domain.Problem
import com.delizarov.taskforces.domain.ResolutionException

/*
* https://leetcode.com/problems/word-pattern/
* */
class P290 : Problem() {

    override fun solve(inputData: InputData): OutputData {
        val input290 = (inputData as? Input290) ?: error("Wrong input 290")

        val pattern = input290.pattern
        val str = input290.str

        return Output290(wordPattern(pattern, str))
    }

    override fun assertOutputValueCorrect(testNo: Int, expectedData: OutputData, actualData: OutputData) {
        val expected = (expectedData as? Output290)?.match ?: error("type mismatch 290")
        val actual = (actualData as? Output290)?.match ?: error("type mismatch 290")

        if (expected != actual) throw ResolutionException("testNo $testNo expected: $expected actual: $actual")
    }

    fun wordPattern(pattern: String, s: String): Boolean {
        val dict = Array<String?>(27) { null }
        val used = mutableSetOf<String>()
        val cursor = Cursor(s.split(' '))

        if (pattern.length != cursor.count) return false

        for (char in pattern) {
            val word = dict[char.index]

            if (word == null) {
                val wordToAdd = cursor.word()
                if (wordToAdd in used) return false

                dict[char.index] = wordToAdd
                used.add(wordToAdd)
            } else {
                if (!cursor.match(word)) return false
            }

            cursor.next()
        }

        return true
    }

    private class Cursor(private val words: List<String>) {
        private var pos = 0

        val count: Int = words.size

        fun next() {
            if (hasNext()) pos++
        }

        fun hasNext() = pos < words.size - 1

        fun word() = words[pos]

        fun match(word: String) = words[pos] == word
    }

    private val aChar = 'a'.toInt()

    private val Char.index: Int
        get() = this.toInt() - aChar
}