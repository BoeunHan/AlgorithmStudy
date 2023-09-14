package `0x11`

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val ropes = ArrayList<Int>()
    repeat(n) {
        ropes.add(readLine().toInt())
    }
    ropes.sortBy { it }
    var max = 0
    for (i in 0 until n) {
        max = maxOf(max, ropes[i] * (n - i))
    }
    println(max)
}