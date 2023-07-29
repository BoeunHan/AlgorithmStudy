package `0x10`

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    val num = readLine().split(" ").map { it.toInt() }
    val sum = IntArray(n + 1)

    sum[0] = 0
    for (i in 1..n) {
        sum[i] = sum[i - 1] + num[i - 1]
    }

    repeat(m) {
        val (i, j) = readLine().split(" ").map { it.toInt() }
        println(sum[j] - sum[i - 1])
    }
}