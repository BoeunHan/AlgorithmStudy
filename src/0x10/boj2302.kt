package `0x10`

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val m = readLine().toInt()
    val spaces = LinkedList<Int>()

    var idx = 0
    repeat(m) {
        val k = readLine().toInt()
        if (k - idx - 1 > 0) spaces.add(k - idx - 1)
        idx = k
    }
    if (n - idx > 0)spaces.add(n - idx)

    var total = 1
    if (spaces.isNotEmpty()) {
        val max = spaces.maxOf { it }
        val dp = Array(2) { Array(max) { 0 } }
        dp[0][0] = 1    //자리 변경 안함
        dp[1][0] = 0    //자리 변경 함
        for (i in 1 until max) {
            dp[0][i] = dp[0][i - 1] + dp[1][i - 1]
            dp[1][i] = dp[0][i - 1]
        }
        for (space in spaces) {
            total *= (dp[0][space - 1] + dp[1][space - 1])
        }
    }

    println(total)
}