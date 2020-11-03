package com.delizarov.taskforces

import com.delizarov.taskforces.domain.ProblemFactory
import com.delizarov.taskforces.domain.ResolutionException

object Application {

    private val problemFactory = ProblemFactory()

    fun run(problemNo: String) {
        val problem = problemFactory.create(problemNo)

        try {
            problem.resolve()

            println("All correct")
        } catch (ex: ResolutionException) {
            println("Problem resolve exception! What went wrong: $ex")
        }
    }
}

fun main(vararg args: String) {
    Application.run(args[0])
}