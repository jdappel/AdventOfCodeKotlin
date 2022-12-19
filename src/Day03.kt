

val lowercase = 'a'..'z'
val uppercase = 'A'..'Z'

fun main() {

    fun logic(input: List<String>): Int {
        return input.fold(0) { acc, line ->
            val (first, second) = line.take(line.length.div(2)) to line.substring(line.length.div(2))
            acc + first.toCharArray().intersect(second.toCharArray().toSet()).sumOf {
                if (it in lowercase) {
                    lowercase.indexOf(it) + 1
                } else if (it in uppercase) {
                    uppercase.indexOf(it) + 27
                } else {
                    0
                }
            }
        }
    }

    fun logic2(input: List<String>): Int {
        return input.chunked(3).fold(0) { acc, lines ->
            val (first, second, third) = lines
            acc + first.toCharArray().intersect(second.toCharArray().toSet().intersect(third.toCharArray().toSet())).sumOf {
                if (it in lowercase) {
                    lowercase.indexOf(it) + 1
                } else if (it in uppercase) {
                    uppercase.indexOf(it) + 27
                } else {
                    0
                }
            }
        }
    }

    // test if implementation meets criteria from the description, like:
    //val testInput = readInput("Day01_test")
    //check(part1(testInput) == 1)

    val input = readInput("Day03_test")
    println(logic2(input))
}