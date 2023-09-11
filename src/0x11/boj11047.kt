package `0x11`

fun main() = with(System.`in`.bufferedReader()) {
    val (n, k) = readLine().split(" ").map { it.toInt() }
    val money = Array(n) { 0 }

    repeat(n) {
        money[it] = readLine().toInt()
    }

    var k1 = k
    var cnt = 0
    for (i in n - 1 downTo 0) {
        cnt += k1 / money[i]
        k1 %= money[i]
    }
    println(cnt)
}