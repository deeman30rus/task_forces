package com.delizarov.taskforces.domain

abstract class Problem {

    private val repository = TestDataRepository()

    fun resolve() {
        val testData = repository.getDataFor(this)

        for ((i, testSample) in testData.withIndex()) {
            val actual = try {
                solve(testSample.input)
            } catch (ex: Exception) {
                throw ResolutionException("Runtime error on test $i $ex")
            }

            if (!testSample.skipCheck) {
                if (testSample.expected == null) error("NPE for expected value when check not skipped")
                assertOutputValueCorrect(i, testSample.expected, actual)
            }
        }

    }

    abstract fun solve(inputData: InputData): OutputData

    /**
     * @throws ResolutionException if check fails
     */
    abstract fun assertOutputValueCorrect(testNo: Int, expectedData: OutputData, actualData: OutputData)
}
