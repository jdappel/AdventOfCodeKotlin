fun makeStack(items: Collection<String>): ArrayDeque<String> {
    val stack = ArrayDeque<String>()
    items.forEach { stack.add(it) }
    return stack
}

fun main() {
    val st1 = makeStack(listOf("Q","F","M","R","L","W","C","V"))
    val st2 = makeStack(listOf("D","Q","L"))
    val st3 = makeStack(listOf("P","S","R","G","W","C","N","B"))
    val st4 = makeStack(listOf("L","C","D","H","B","Q","G"))
    val st5 = makeStack(listOf("V","G","L","F","Z","S"))
    val st6 = makeStack(listOf("D","G","N","P"))
    val st7 = makeStack(listOf("D","Z","P","V","F","C","W"))
    val st8 = makeStack(listOf("C","P","D","M","S"))
    val st9 = makeStack(listOf("Z","N","W","T","V","M","C","P"))
    val inputToStack = mapOf(1 to st1, 2 to st2, 3 to st3, 4 to st4, 5 to st5, 6 to st6, 7 to st7, 8 to st8, 9 to st9)

    fun part1(input: List<String>): String {
        input.forEach { line ->
            val (cnt, from, to) = line.split(" ")
            for (i in 1..cnt.toInt()) {
                val popStack = inputToStack[from.toInt()]
                val pushStack = inputToStack[to.toInt()]
                pushStack?.add(popStack?.removeLast() ?: "")
            }
        }
        return listOf<String>(st1.last(),st2.last(),st3.last(),st4.last(),st5.last(),st6.last(),st7.last(),st8.last(),st9.last()).joinToString(separator = "") { it }
    }

    fun part2(input: List<String>): String {
        input.forEach { line ->
            val (cnt, from, to) = line.split(" ").map { it.toInt() }
            val popStack = inputToStack[from]
            val pushStack = inputToStack[to]
            if (cnt == 1) {
                pushStack?.add(popStack?.removeLast() ?: "")
            }
            else {
                val tmpStack = ArrayDeque<String>()
                for (i in 1..cnt) {
                    tmpStack.add(popStack?.removeLast() ?: "")
                }
                for (i in 1..cnt) {
                    pushStack?.add(tmpStack?.removeLast() ?: "")
                }
            }
        }
        return listOf<String>(st1.last(),st2.last(),st3.last(),st4.last(),st5.last(),st6.last(),st7.last(),st8.last(),st9.last()).joinToString(separator = "") { it }
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day05_test")
    println(part2(input))
}