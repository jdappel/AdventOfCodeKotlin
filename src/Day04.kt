fun main() {

    fun part1(input: List<String>): Int {
        return input.fold(0) { acc, line ->
            val (firstElf, secondElf) = line.split(",")
            val (firstElfStart, firstElfEnd) = firstElf.split("-")
            val (secondElfStart, secondElfEnd) = secondElf.split("-")
            val firstElfRange = firstElfStart.toInt()..firstElfEnd.toInt()
            val secondElfRange = secondElfStart.toInt()..secondElfEnd.toInt()
            val cnt = if (secondElfRange.all { it in firstElfRange } || firstElfRange.all { it in secondElfRange }) 1 else 0
            acc + cnt
            }
        }

    fun part2(input: List<String>): Int {
        return input.fold(0) { acc, line ->
            val (firstElf, secondElf) = line.split(",")
            val (firstElfStart, firstElfEnd) = firstElf.split("-")
            val (secondElfStart, secondElfEnd) = secondElf.split("-")
            val firstElfRange = firstElfStart.toInt()..firstElfEnd.toInt()
            val secondElfRange = secondElfStart.toInt()..secondElfEnd.toInt()
            val cnt = if (secondElfRange.any { it in firstElfRange } || firstElfRange.any { it in secondElfRange }) 1 else 0
            acc + cnt
        }
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day04_test")
    println(part2(input))
}