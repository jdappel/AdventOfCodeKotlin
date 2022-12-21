import kotlin.math.log

fun main() {

    fun logic(input: List<String>, window: Int): Int {
        return input.fold(0) { acc, line ->
            val marker = line.windowedSequence(size = window, step = 1).first { slice ->
                slice.toSet().size == window
            }
            acc + line.indexOf(marker) + window
        }
    }

    fun part1(input: List<String>): Int {
        return logic(input, 4)
     }

    fun part2(input: List<String>): Int {
        return logic(input, 14)
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day06_test")
    println(part2(input))
}