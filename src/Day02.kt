enum class Values(val pts: Int) {
    ROCK(1), PAPER(2), SCISSORS(3)
}

val resultMap: Map<String, Map<String, Int>> = mapOf(
    "A" to mapOf("X" to 3, "Y" to 6, "Z" to 0),
    "B" to mapOf("X" to 0, "Y" to 3, "Z" to 6),
    "C" to mapOf("X" to 6, "Y" to 0, "Z" to 3)
)
val reverseMap = mapOf("X" to Values.ROCK, "Y" to Values.PAPER, "Z" to Values.SCISSORS)
val part2ScoreMap = mapOf("X" to 0, "Y" to 3, "Z" to 6)
val part2PlayMap: Map<String, Map<Int, String>> = mapOf(
    "A" to mapOf(3 to "X", 6 to "Y", 0 to "Z"),
    "B" to mapOf(0 to "X", 3 to "Y", 6 to "Z"),
    "C" to mapOf(6 to "X", 0 to "Y", 3 to "Z")
)

fun score(elf: String, me: String): Int {
    val score = resultMap[elf]?.get(me) ?: 0
    return score + (reverseMap[me]?.pts ?: 0)
}

fun score2(elf: String, me: String): Int {
    val score = part2ScoreMap[me] ?: 0
    return score + (reverseMap[part2PlayMap[elf]?.get(score)]?.pts ?: 0)
}

fun main() {
    fun logic(input: List<String>): Int {
        return input.fold(0) { acc, line ->
            val (elf, me) = line.split(" ")
            acc + score2(elf, me)
        }
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day02_test")
    println(logic(input))
}
