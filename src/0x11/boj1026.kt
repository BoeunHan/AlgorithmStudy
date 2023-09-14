package `0x11`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val a = readLine().split(" ").map { it.toInt() }
    val b = readLine().split(" ").map { it.toInt() }

    val a1 = a.sorted()
    val b1 = b.sortedDescending()

    var result = 0
    for (i in 0 until n) {
        result += a1[i] * b1[i]
    }
    println(result)
}