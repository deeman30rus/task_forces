import java.lang.AssertionError
import java.util.*

fun longestValidParentheses(str: String): Int {
    val stack = Stack<Int>()

    for (c in str) {
        when (c) {
            '(' -> stack.push(1)
            ')' -> handleRight(stack)
        }
    }

    return stack.max() ?: 0
}

fun handleRight(stack: Stack<Int>) {
    if (stack.isEmpty()) {
        return
    }

    val top1 = stack.pop()
    if (top1 == 1) {
        stack.push(2)
    } else {
        if (top1 > 1) {
            if (stack.isEmpty()) {
                stack.push(top1)
                stack.push(-1)
            } else {
                val top2 = stack.pop()
                if (top2 == 1) {
                    stack.push(top1 + 2)
                } else {
                    stack.push(top2)
                    stack.push(top1)
                    stack.push(-1)
                }
            }
        } else {
            stack.push(top1)
            stack.push(-1)
        }
    }

    if (stack.size > 1) {
        val elTop1 = stack.pop()
        val elTop2 = stack.pop()
        if (elTop1 > 1 && elTop2 > 1) {
            stack.push(elTop1 + elTop2)
        } else {
            stack.push(elTop2)
            stack.push(elTop1)
        }
    }
}

val cases = mapOf(
        "()" to 2,
        "(()" to 2,
        ")()())" to 4,
        "" to 0,
        "(()((((()" to 2,
        "(()((((()()()(((()" to 6,
        "))))())()()(()" to 4,
        "()()" to 4,
        "()())" to 4,
        "(()()" to 4,
        "(()())" to 6,
        ")(()()))" to 6,
        ")(()()))(" to 6,
        "((())" to 4
)

cases.toList().forEachIndexed { i, (str, expectedResult) ->
    val result = longestValidParentheses(str)
    if (result != expectedResult) {
        throw AssertionError("Case: $i; Expected: ${expectedResult}; actual: $result")
    }
}

println("Vse OK!")