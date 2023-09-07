package `0x10`

import java.lang.Integer.max

fun main() = with(System.`in`.bufferedReader()) {
    repeat(readLine().toInt()) {
        val n = readLine().toInt()
        val stickers = List(2) { readLine().split(" ").map { it.toInt() } }

        val dp = List(3) { MutableList(n) { 0 } }
        dp[0][0] = stickers[0][0]
        dp[1][0] = stickers[1][0]
        dp[2][0] = 0

        for (i in 1 until n) {
            dp[0][i] = max(dp[1][i - 1], dp[2][i - 1]) + stickers[0][i]
            dp[1][i] = max(dp[0][i - 1], dp[2][i - 1]) + stickers[1][i]
            dp[2][i] = max(max(dp[0][i - 1], dp[1][i - 1]), dp[2][i - 1])
        }
        println(max(max(dp[0][n - 1], dp[1][n - 1]), dp[2][n - 1]))
    }
}