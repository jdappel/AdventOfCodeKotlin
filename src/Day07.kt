fun main() {

    fun logic(input: List<String>): Map<Int,Int> {
        val stack: ArrayDeque<Int> = ArrayDeque()
        val sizes = mutableMapOf<Int,Int>()
        input.forEachIndexed { i, line ->
            if (line.startsWith("cd") && line.contains("..")) {
                stack.removeLast()
            } else if (line.startsWith("cd")) {
                stack.add(i)
                sizes[i] = 0
            } else {
                val size = line.split(" ").first().toInt()
                for (idx in stack) {
                    val idxsz = sizes[idx] ?: 0
                    sizes[idx] = idxsz + size
                }
            }
        }
        return sizes
    }

    val input: List<String> = readInput("Day07_test")
    val linesWithSizes = input.map { it.replace("$ ", "")}.filterNot { it.startsWith("ls") || it.startsWith("dir") }

    val sizes = logic(linesWithSizes)
    val unused = 70000000 - sizes[0]!!
    val needed = 30000000 - unused
    val min = sizes.filter { it.value >= needed }.map { it.value }.min()
    println(min)
}