package `0x10`

import java.lang.Integer.max
import java.lang.Integer.min
import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val (t, w) = readLine().split(" ").map { it.toInt() }
    val plum = Array(2) { LinkedList<Int>() }
    repeat(t) {
        val n = readLine().toInt()
        if (n == 1) {
            if (plum[0].isEmpty() || plum[0].last == 0) plum[0].add(1)
            else plum[0][plum[0].size - 1]++
            if (plum[1].isEmpty() || plum[1].last != 0) plum[1].add(0)
        } else {
            if (plum[1].isEmpty() || plum[1].last == 0) plum[1].add(1)
            else plum[1][plum[1].size - 1]++
            if (plum[0].isEmpty() || plum[0].last != 0) plum[0].add(0)
        }
    }
    val size = plum[0].size
    val dp = Array(w + 1) { Array(size) { 0 } }
    dp[0][0] = plum[0][0]
    dp[1][0] = plum[1][0]

    for (i in 1 until size) {
        for (j in 0..min(w, i + 1)) {
            if (j == 0) dp[j][i] = dp[0][i - 1] + plum[0][i]
            else {
                dp[j][i] = max(dp[j - 1][i - 1], dp[j][i - 1]) + plum[j % 2][i]
            }
        }
    }

    var result = 0
    for (i in 0..w) {
        result = max(result, dp[i][size-1])
    }
    println(result)
}