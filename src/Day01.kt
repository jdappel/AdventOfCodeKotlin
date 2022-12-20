fun main() {

    fun logic(input: List<String>): Map<Int,Int> {
        var elves = mutableMapOf<Int,Int>()
        var tmp = 0
        var cnt = 0
        input.forEach { line ->
            if (line.isNotEmpty()) {
                tmp += line.toInt()
            }
            else {
                elves[++cnt] = tmp
                tmp = 0
            }
        }
        return elves
    }

    fun part1(input: List<String>): Int {
        return logic(input).maxBy { entry -> entry.value }.value
    }

    fun part2(input: List<String>): Int {
        return logic(input).entries.sortedByDescending { entry -> entry.value }.take(3).sumOf { it.value }
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day01_test")
    println(part1(input))
    println(part2(input))
}
