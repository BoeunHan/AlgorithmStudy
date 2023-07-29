package `0x10`

import java.lang.Integer.min

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val paints = Array(n) { IntArray(3) }
    val dp = Array(n) { IntArray(3) }
    repeat(n) {
        val (r, g, b) = readLine().split(" ").map { it.toInt() }
        paints[it][0] = r
        paints[it][1] = g
        paints[it][2] = b
    }

    dp[0][0] = paints[0][0]
    dp[0][1] = paints[0][1]
    dp[0][2] = paints[0][2]

    for (i in 1 until n) {
        dp[i][0] = min(dp[i - 1][1], dp[i - 1][2]) + paints[i][0]
        dp[i][1] = min(dp[i - 1][0], dp[i - 1][2]) + paints[i][1]
        dp[i][2] = min(dp[i - 1][0], dp[i - 1][1]) + paints[i][2]

    }
    println(dp[n - 1].minOf { it })
}