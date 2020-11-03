package com.delizarov.taskforces.domain

class TestData private constructor(list: List<TestSample>): List<TestSample> by list {

    class Builder {

        val list = mutableListOf<TestSample>()

        fun build(): TestData = TestData(list)
    }
}

abstract class InputData
abstract class OutputData

class TestSample(
    val input: InputData,
    val expected: OutputData?,
    val skipCheck: Boolean
) {
    constructor(builder: Builder) : this(builder.input, builder.expected, builder.skipCheck)

    class Builder {

        lateinit var input: InputData
        var expected: OutputData? = null
        var skipCheck = false

        fun build() = TestSample(this)
    }
}

// DSL

fun testSet(block: TestData.Builder.() -> Unit) = TestData.Builder().apply(block).build()

fun TestData.Builder.sample(block: TestSample.Builder.() -> Unit) {
    this.list.add(TestSample.Builder().apply(block).build())
}
